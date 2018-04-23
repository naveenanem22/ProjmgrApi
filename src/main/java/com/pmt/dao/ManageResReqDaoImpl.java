package com.pmt.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value="manageResReqDaoImpl")
public class ManageResReqDaoImpl implements ManageResReqDao {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void populateResReq(Map<String,String> resReqForm) {
				
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Session session = sessionFactory.getCurrentSession();
		
		SQLQuery sqlQuery = session.createSQLQuery(
				"INSERT INTO resallreq(rar_projectid,rar_status,rar_requestid,rar_owner,rar_billable) "
				+ "VALUES(:projectid,:status,:requestid,:owner,:billable)");
		sqlQuery.setParameter("projectid", Integer.parseInt(resReqForm.get("projectid")));
		sqlQuery.setParameter("status", "new");
		sqlQuery.setParameter("requestid", "rar001");
		sqlQuery.setParameter("owner", Integer.parseInt(resReqForm.get("resourceid")));
		sqlQuery.setParameter("billable", resReqForm.get("billable"));		
		sqlQuery.executeUpdate();
		sqlQuery = session.createSQLQuery("SELECT LAST_INSERT_ID()");
		int requestid = Integer.parseInt(sqlQuery.list().get(0).toString());
		for(int i=0;i<10;i++){
			
				if(resReqForm.containsKey("rescount"+i))
				{				
					for(int j=0;j<Integer.parseInt(resReqForm.get("rescount"+i));j++){
						sqlQuery = session.createSQLQuery(
								"INSERT "
								
								+ "INTO resallreqdetail(rard_resallreqid,"
								+ "rard_primaryskillid,rard_secondaryskillid,"
								+ "rard_status,rard_requestid,rard_startdate,rard_enddate,"
								+ "rard_rmgapprover,"
								+ "rard_deliveryapprover,rard_requesttype,"
								+ "rard_rolerequired,rard_allctype,rard_clientinterview,rard_competencygroup,"
								+ "rard_location) "
								
								+ "VALUES(:resallreqid,"
								+ ":primaryskillid,:secondaryskillid,"
								+ ":status,:requestid,:startdate,:enddate,"
								+ ":rmgapprover,"
								+ ":deliveryapprover,:requesttype,"
								+ ":rolerequired,:allctype,:clientinterview,:competencygroup,"
								+ ":location)");
						//sqlQuery.setParameter("resallreqrequestid", "rar001");
						sqlQuery.setParameter("resallreqid", requestid);
						sqlQuery.setParameter("primaryskillid", Integer.parseInt(resReqForm.get("primaryskill"+i)));
						sqlQuery.setParameter("secondaryskillid", Integer.parseInt(resReqForm.get("secondaryskill"+i)));
						sqlQuery.setParameter("status", "new");
						sqlQuery.setParameter("requestid", "rard001");
						sqlQuery.setParameter("rmgapprover",1);
						sqlQuery.setParameter("deliveryapprover", 1);
						sqlQuery.setParameter("requesttype", resReqForm.get("requesttype"+i));
						sqlQuery.setParameter("rolerequired", resReqForm.get("rolerequired"+i));
						sqlQuery.setParameter("allctype", resReqForm.get("allctype"+i));
						sqlQuery.setParameter("clientinterview", resReqForm.get("clientinterview"+i));
						sqlQuery.setParameter("competencygroup", resReqForm.get("competencygrp"+i));
						sqlQuery.setParameter("location", Integer.parseInt(resReqForm.get("location"+i)));
						
						try {
							sqlQuery.setParameter("startdate", dateFormatter.parse(resReqForm.get("allcstartdate"+i)));
							sqlQuery.setParameter("enddate", dateFormatter.parse(resReqForm.get("allcenddate"+i)));
						} catch (ParseException e) {
							
							e.printStackTrace();
						}
						sqlQuery.executeUpdate();
						
						}
				
				}
				else
					break;
			
				
		}
		
		
		
		
	}

	
	
	@Override	
	public  List listResReq(){
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery =  session.createSQLQuery("SELECT * FROM resallreq AS rar"
				+ "INNER JOIN resallreqdetail AS rard WHERE rar_id=rard_resallreqid");
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return sqlQuery.list();
		
		
	}

	@Override
	public void populateResAll() {		
		
	}


	@Override
	public void processNewResReq(Integer[] reqDetIds) {
		Session session = sessionFactory.getCurrentSession();		
		for(int i=0;i<reqDetIds.length;i++){
		SQLQuery sqlQuery =  session.createSQLQuery("UPDATE resallreqdetail SET rard_status=:rardnewstatus WHERE rard_id=:rardid AND rard_status=:rardoldstatus");
		sqlQuery.setParameter("rardid", reqDetIds[i]);
		sqlQuery.setParameter("rardnewstatus", "Open");
		sqlQuery.setParameter("rardoldstatus", "new");			
		sqlQuery.executeUpdate();
		}
	}
	
	
	

}
