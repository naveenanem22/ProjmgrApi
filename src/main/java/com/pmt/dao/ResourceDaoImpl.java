package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Resource;

@Repository(value="resourceDaoImpl")
public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addResource(Resource resource) {
		
		Session session;
		try{
		session = this.sessionFactory.getCurrentSession();
		}
		catch (Exception ex) {
            session = this.sessionFactory.openSession();
        }
		
		session.saveOrUpdate(resource);
		
		
		
	}

	@Override
	public void updateResource(Resource resource) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(resource);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> listResources() {
		Session session;
		try{
		session = this.sessionFactory.getCurrentSession();
		
		}
		catch(Exception ex){
			session = this.sessionFactory.openSession();
			
		}
		List<Resource> resourceList = session.createQuery("from Resource").list();
		return resourceList;
	}

	@Override
	public Resource getResourceById(int id) {
		
		Session session;
		try{
			
		session = this.sessionFactory.getCurrentSession();	
	
		}
		catch(Exception ex){		
			session = this.sessionFactory.openSession();				
		}
		Resource resource  = (Resource) session.load(Resource.class, new Integer(id));	
		
		return resource;
		
	}

	@Override
	public void removeResource(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Resource resource = (Resource) session.load(Resource.class, new Integer(id));
		if(null!=resource){
			session.delete(resource);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourcesByName(String name) {
		
		 name = "%"+name+"%";
	        Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Resource AS cl WHERE cl.name like :resourcename");
			query.setParameter("resourcename", name);		
			return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resource> getResourcesById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Resource AS cl WHERE cl.id = :resourceid");
		query.setParameter("resourceid", id);
		return query.list();
		
	}

	@Override
	public int updateResourceSkill(int resourceId,int skillId, int selfRating, boolean coreSkill) {		
		Session session = this.sessionFactory.getCurrentSession();		
		
		SQLQuery query = session.createSQLQuery("INSERT INTO resourceskill(rs_resourceid,rs_skillid,rs_coreskill,"
				+ "rs_selfrating) VALUES(:resourceid,:skillid,:coreskill,:selfrating)");
		query.setParameter("resourceid", resourceId);
		query.setParameter("skillid", skillId);
		query.setParameter("coreskill", coreSkill);
		query.setParameter("selfrating", selfRating);
		return query.executeUpdate();	
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getResourceSkillIds(int resourceId) {
		Session session =  this.sessionFactory.getCurrentSession();
		SQLQuery query = session.createSQLQuery("SELECT rs_skillid FROM resourceskill WHERE rs_resourceid=:resourceid");
		query.setParameter("resourceid", resourceId);				
		return (List<Integer>)query.list();	
		
	}
	
	
	

}
