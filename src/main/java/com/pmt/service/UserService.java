package com.pmt.service;

import java.util.List;

public interface UserService {
	public boolean validateUser(String username, String password);
	public int getUserResourceId(String username);

}
