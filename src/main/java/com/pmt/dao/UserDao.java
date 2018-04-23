package com.pmt.dao;

import java.util.List;

public interface UserDao {
	public boolean validateUser(String username, String password);
	public List getUserResourceId(String username);


}
