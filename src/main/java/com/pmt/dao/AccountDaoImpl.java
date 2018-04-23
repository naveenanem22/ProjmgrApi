package com.pmt.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.pmt.model.Account;

@Repository(value="accountDaoImpl")
public class AccountDaoImpl implements AccountDao {

	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void addAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		//session.persist(account);
		session.saveOrUpdate(account);
		
	}

	@Override
	public void updateAccount(Account account) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(account);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> listAccounts() {
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Account> accountList = session.createQuery("from Account").list();
		return accountList;
	}

	@Override
	public Account getAccountById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Account account  = (Account) session.load(Account.class, new Integer(id));		
		return account;
		
	}

	@Override
	public void removeAccount(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Account account = (Account) session.load(Account.class, new Integer(id));
		if(null!=account){
			session.delete(account);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccountsByName(String name) {
		
		 name = "%"+name+"%";
	        Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Account AS ac WHERE ac.name like :accountname");
			query.setParameter("accountname", name);		
			return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAccountsById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Account AS ac WHERE ac.id = :accountid");
		query.setParameter("accountid", id);
		return query.list();
		
	}
	
	
	

}
