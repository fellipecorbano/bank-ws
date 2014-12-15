package com.ciandt.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ciandt.beans.Transaction;

@WebService(name="TransactionWebService")
public interface ITransactionWebService {
	
	@WebMethod
	public boolean addTransaction(@WebParam(name="cpf") long cpf, 
			@WebParam(name="transaction") Transaction transaction);
	
	@WebMethod
	public List<Transaction> listTransactions(@WebParam(name="cpf") long cpf);	
	
}
