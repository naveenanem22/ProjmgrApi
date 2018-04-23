package com.pmt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.ManageResReqDao;

@Service(value="manageResReqServiceImpl")
public class ManageResReqServiceImpl implements ManageResReqService{
	
	@Autowired
	@Qualifier(value="manageResReqDaoImpl")
	private ManageResReqDao manageResReqDao;

	@Override
	@Transactional
	public void populateResReq(Map<String,String> resReqForm) {
		
		manageResReqDao.populateResReq(resReqForm);		
		
	}

	

	@Override
	public void populateResAll() {
		// TODO Auto-generated method stub
		
	}



	@Override
	@Transactional
	public List listResReq() {
		return manageResReqDao.listResReq();
		
	}



	@Override
	@Transactional
	public void processNewResReq(Integer[] reqDetIds) {
		
		manageResReqDao.processNewResReq(reqDetIds);
	}
	
	

}
