package com.revature;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.revature.DAOpackage.AccountDao;
import com.revature.DAOpackage.TransactionDao;
import com.revature.DAOpackage.UserDao;
import com.revature.models.Account;

import static org.junit.Assert.assertNotNull;

public class UserTest {
	
	private static final AccountDao accDao = new AccountDao();
	private static final UserDao usDao = new UserDao();
	private static final TransactionDao tDao = new TransactionDao();
	
	@Test
	public void findAllAccounts() {	
		List<Account> accounts = accDao.findAll();
		assertNotNull(accounts);
	}
	
	@Test
	public void findAccount() {
		List<Account> account =  accDao.findByUserID(1);	
		assertNotNull(account);
		
	}
	
	
}	

