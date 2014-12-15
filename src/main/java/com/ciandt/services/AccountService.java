package com.ciandt.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ciandt.beans.Account;
import com.ciandt.dao.AccountDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {		
			
	@Autowired
	AccountDAO accountDAO;
	
	public Account getAccountByCPF(Long cpf) {		
		return accountDAO.getAccountByCPF(cpf);
	}

	public Account addAccount(Account c) {		
		return accountDAO.addAccount(c);
	}

	public boolean removeAccountByCPF(long cpf) {
		return accountDAO.removeAccountByCPF(cpf);
	}

}
