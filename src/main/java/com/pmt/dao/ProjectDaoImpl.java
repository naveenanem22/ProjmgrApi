package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Project;

@Repository(value="projectDaoImpl")
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(project);
		session.saveOrUpdate(project);
		
	}

	@Override
	public void updateProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(project);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listProjects() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Project> projectList = session.createQuery("from Project").list();
		return projectList;
	}

	@Override
	public Project getProjectById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Project project  = (Project) session.load(Project.class, new Integer(id));		
		return project;
		
	}

	@Override
	public void removeProject(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Project project = (Project) session.load(Project.class, new Integer(id));
		if(null!=project){
			session.delete(project);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsByName(String name) {
		
		 name = "%"+name+"%";
	        Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Project AS cl WHERE cl.name like :projectname");
			query.setParameter("projectname", name);		
			return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> getProjectsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Project AS cl WHERE cl.id = :projectid");
		query.setParameter("projectid", id);
		return query.list();
		
	}
	
	
	

}
