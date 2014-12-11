package com.ciandt.services;

import org.springframework.stereotype.Service;

import com.ciandt.beans.Account;
import com.ciandt.dao.DAOMock;

@Service
public class ClasseDeTestes {

	public Account getAccountByCPF(Long cpf) {		
		return DAOMock.getAccountsMock().get(cpf);
	}

	public Account addAccount(Account c) {		
		return DAOMock.addAccount(c);
	}

	public boolean removeAccountByCPF(long cpf) {
		return DAOMock.removeAccount(cpf);
	}
}
