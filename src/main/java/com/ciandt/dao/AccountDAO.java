package com.ciandt.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ciandt.beans.Account;
import com.ciandt.interfaces.IAccountDAO;

@Repository
public class AccountDAO extends BaseDAO implements IAccountDAO{
					
	public Account getAccountByCPF(Long cpf) {			
							
		String hql = "FROM Account WHERE cpf=:cpf";
		Query query = getSession().createQuery(hql);
		query.setParameter("cpf", cpf);
		List<Account> result = query.list();		
					
		if(!result.isEmpty())
			return result.get(0);			
		
		return null;					
	}
	
	public boolean accountExists(long cpf) {
		Account c = getAccountByCPF(cpf);		
		
		if(c==null)	
			return false;		
		return true;
	}
	
	public Account addAccount(Account account){
		getSession().save(account);		
		return account;	
	}

	public boolean removeAccountByCPF(long cpf) {		
		String hql = "DELETE FROM Account WHERE cpf=:cpf";
		Query query = getSession().createQuery(hql);
		query.setParameter("cpf", cpf);
		int result = query.executeUpdate();
		
		if(result>0)
			return true;
				
		return false;
	}
	
}
