package com.pmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.dao.AccountDao;
import com.pmt.model.Account;


@Service(value="accountServiceImpl")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	@Qualifier("accountDaoImpl")
	private AccountDao accountDao;

	@Override
	@Transactional
	public void addAccount(Account account) {
		accountDao.addAccount(account);
		
	}

	@Override
	@Transactional
	public void updateAccount(Account account) {
		
		accountDao.updateAccount(account);
	}

	@Override
	@Transactional
	public List<Account> listAccounts() {
		
		return accountDao.listAccounts();
	}

	@Override
	@Transactional
	public Account getAccountById(int id) {
		
		return accountDao.getAccountById(id);
	}

	@Override
	@Transactional
	public void removeAccount(int id) {
		
		accountDao.removeAccount(id);
	}

	@Override
	@Transactional
	public List<Account> getAccountsByName(String name) {
		
		return accountDao.getAccountsByName(name);
	}

	@Override
	@Transactional
	public List<Account> getAccountsById(int id) {
		
		return accountDao.getAccountsById(id);
	}

		
	

}
