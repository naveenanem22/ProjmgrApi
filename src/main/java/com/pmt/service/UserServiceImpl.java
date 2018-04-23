package com.pmt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.UserDao;

@Service(value="userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier(value="userDaoImpl")
	private UserDao userDao;
	

	@Override
	@Transactional
	public boolean validateUser(String username, String password) {
		return userDao.validateUser(username, password);
		
	}

	@Override
	@Transactional
	public int getUserResourceId(String username) {
		
		Map result = (Map)userDao.getUserResourceId(username).get(0);
		return (int)result.get("u_resourceid");
		
	}

}
