package com.pmt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value="userDaoImpl")
public class UserDaoImpl implements UserDao{
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public boolean validateUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT * FRoM user WHERE u_username = :username and u_password=:password");
		sqlQuery.setParameter("username", username);
		sqlQuery.setParameter("password", password);
		if(sqlQuery.list().size() == 1){
			return true;
		}
		return false;
	}

	@Override
	public List getUserResourceId(String username) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT u_resourceid FROM user WHERE u_username=:username");
		sqlQuery.setParameter("username", username);
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List result = sqlQuery.list();
		if(result.size()==1)
		return result;
		else return null;
	}

}
