package com.pmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.TestDao;
import com.pmt.dao.TestDaoImpl;

@Service(value="testServiceImpl")
public class TestServiceImpl implements TestService {
	
	@Autowired
	@Qualifier("testDaoImpl")
	private TestDao testDao;

	@Override
	@Transactional
	public void testServiceMethod1() {		
		testDao.testDaoMethod1();
		testServiceMethod2();

	}
	
	@Override
	@Transactional(propagation=Propagation.NEVER)
	public void testServiceMethod2(){
		testDao.testDaoMethod2();
	}

}
