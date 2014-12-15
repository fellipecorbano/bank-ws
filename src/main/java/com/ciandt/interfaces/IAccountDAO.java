package com.ciandt.interfaces;

import com.ciandt.beans.Account;

public interface IAccountDAO {

	public Account getAccountByCPF(Long cpf);

	public Account addAccount(Account c);

	public boolean removeAccountByCPF(long cpf);
	
	public boolean accountExists(long cpf);
	
}
