package com.pmt.dao;

import java.util.List;



public interface ManagerProjectAccountDao {
	public List getProjectsUnderResource(int resourceId);
	public List getProjectsUnderAccount(int accountId);
	public List getAccountsUnderResource(int resourceId);
}
