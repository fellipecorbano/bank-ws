package com.ciandt.interfaces;

import java.util.List;

import com.ciandt.beans.Transaction;

public interface ITransactionDAO {
	
	public boolean addTransaction(long cpf, Transaction transaction);
	
	public List<Transaction> listTransactions(long cpf);
}
