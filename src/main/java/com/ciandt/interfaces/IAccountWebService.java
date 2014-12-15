package com.ciandt.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ciandt.beans.Account;

@WebService(name="AccountWebService")
public interface IAccountWebService {
	
	@WebMethod
	public Account getAccountByCPF(@WebParam(name="cpf") long cpf);	
	
	@WebMethod
	public Account addAccount(@WebParam(name="account") Account account);
	
	@WebMethod
	public boolean removeAccountByCPF(@WebParam(name="cpf") long cpf);
	
}
