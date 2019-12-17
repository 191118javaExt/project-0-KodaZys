package com.revature.service;

import java.util.List;

import com.revature.DAOpackage.TransactionDao;
import com.revature.models.Transaction;

public class TransactionService {

	static TransactionDao tDao = new TransactionDao();
	
	public List<Transaction> getTransactionsbyUser(int usrId, int accId){
		List<Transaction> transactions = tDao.findByUserID(usrId, accId);
		if (transactions.isEmpty()) {
			return null;
		}
		return transactions;
	}
	
	public void createTransaction(Transaction t) {
		tDao.create(t);
	}
}