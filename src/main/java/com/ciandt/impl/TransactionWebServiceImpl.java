package com.ciandt.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ciandt.beans.Transaction;
import com.ciandt.interfaces.ITransactionWebService;
import com.ciandt.services.TransactionService;

@WebService(endpointInterface="com.ciandt.interfaces.ITransactionWebService")
@Service
public class TransactionWebServiceImpl implements ITransactionWebService {	
	
	@Autowired
	public TransactionService transactionService;
			
	public boolean addTransaction(long cpf, Transaction transaction) {
		return transactionService.addTransaction(cpf, transaction);
	}

	public List<Transaction> listTransactions(long cpf) {
		return transactionService.listTransactions(cpf);
	}

}
