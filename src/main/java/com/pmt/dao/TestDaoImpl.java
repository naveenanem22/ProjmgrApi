package com.pmt.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="testDaoImpl")
public class TestDaoImpl implements TestDao {
	
	
	@Autowired
	@Qualifier(value="hibernate4AnnotatedSessionFactory")
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

	@Override	
	public void testDaoMethod1() {
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("This is from method1...");
		System.out.println(session);
		System.out.println(session.getTransaction());
		

	}
	
    @Override
	public void testDaoMethod2(){
    	Session session = this.sessionFactory.getCurrentSession();
		System.out.println("This is from method2...");
		System.out.println(session);
		System.out.println(session.getTransaction());
	}

}
