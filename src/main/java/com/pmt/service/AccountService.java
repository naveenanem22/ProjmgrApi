package com.pmt.service;

import java.util.List;

import com.pmt.model.Account;

public interface AccountService {
	
	public void addAccount(Account account);
    public void updateAccount(Account account);
    public List<Account> listAccounts();
    public Account getAccountById(int id);
    public void removeAccount(int id);
    public List<Account> getAccountsByName(String name);
    public List<Account> getAccountsById(int id);
	

}
