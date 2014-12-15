package com.ciandt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.beans.Transaction;
import com.ciandt.dao.TransactionDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class TransactionService {	
	
	@Autowired
	TransactionDAO transactionDAO;
	
	public boolean addTransaction(long cpf, Transaction transaction) {
		return transactionDAO.addTransaction(cpf, transaction);	
	}

	public List<Transaction> listTransactions(long cpf) {
		return transactionDAO.listTransactions(cpf);
	}
	
	public boolean removeTransactions(long cpf) {
		return transactionDAO.removeTransactions(cpf);
	}

}
