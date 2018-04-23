package com.pmt.dao;

import java.util.List;

import com.pmt.model.Account;


public interface AccountDao {
	
	public void addAccount(Account account);
    public void updateAccount(Account client);
    public List<Account> listAccounts();
    public Account getAccountById(int id);
    public void removeAccount(int id);
    public List<Account> getAccountsByName(String name);
    public List<Account> getAccountsById(int id);
	

}
