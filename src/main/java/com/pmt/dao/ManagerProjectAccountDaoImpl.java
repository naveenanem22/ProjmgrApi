package com.pmt.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value="managerProjectAccountDaoImpl")
public class ManagerProjectAccountDaoImpl implements ManagerProjectAccountDao {
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List getProjectsUnderResource(int resourceId) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT prj_id FROM project INNER JOIN resource WHERE prj_resourceid = res_id AND res_id=:res_id");
		sqlQuery.setParameter("res_id", resourceId);
		return sqlQuery.list();
	}

	@Override
	public List getProjectsUnderAccount(int accountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getAccountsUnderResource(int resourceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
