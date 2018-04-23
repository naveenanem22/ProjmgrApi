package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Region;

@Repository(value="regionDaoImpl")
public class RegionDaoImpl implements RegionDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addRegion(Region region) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(region);
		
	}

	@Override
	public void updateRegion(Region region) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(region);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> listRegions() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Region> regionList = session.createQuery("from Region").list();
		return regionList;
	}

	@Override
	public Region getRegionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Region region  = (Region) session.load(Region.class, new Integer(id));		
		return region;
		
	}

	@Override
	public void removeRegion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Region region = (Region) session.load(Region.class, new Integer(id));
		if(null!=region){
			session.delete(region);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> getRegionsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Region AS rg WHERE rg.id = :regionid");
		query.setParameter("regionid", id);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Region> getRegionsByName(String name) {
		name = "%"+name+"%";
        Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Region AS rg WHERE rg.name like :regionname");
		query.setParameter("regionname", name);		
		return query.list();
	}
	
	
	

}
