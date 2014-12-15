package com.ciandt.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciandt.beans.Account;
import com.ciandt.beans.Transaction;
import com.ciandt.enumeration.TransactionType;
import com.ciandt.interfaces.ITransactionDAO;

@Repository
public class TransactionDAO extends BaseDAO implements ITransactionDAO {
	
	@Autowired
	AccountDAO aDAO;
	
	public boolean addTransaction(long cpf, Transaction transaction) {			
		
		Account acc = aDAO.getAccountByCPF(cpf);
		transaction.setAccount(acc);
		
		// Insert transaction
		getSession().save(transaction);
		
		//Update account balance
		if(transaction.getType().equals(TransactionType.INCOME))
			acc.setBalance(acc.getBalance() + transaction.getAmount());
		else if(transaction.getType().equals(TransactionType.EXPENSE))
			acc.setBalance(acc.getBalance() - transaction.getAmount());		
		
		getSession().update(acc);
		
		return true;
	}

	public List<Transaction> listTransactions(long cpf) {
		
		List<Transaction> resultTrans=null;
		
		// Getting account ID with CPF
		String hql = "SELECT accountId FROM Account WHERE cpf=:cpf";
		Query query = getSession().createQuery(hql);
		query.setParameter("cpf", cpf);
		List<Account> resultAcc = query.list();	
		
		hql = "FROM Transaction WHERE accountId=:accountId";
		query = getSession().createQuery(hql);
		query.setParameter("accountId", resultAcc.get(0));
		resultTrans = query.list();			
				
		if(!resultTrans.isEmpty())
			return resultTrans;
		
		return null;
	}
	
	public boolean removeTransactions(long cpf) {
				
		// Getting account ID with CPF
		String hql = "SELECT accountId FROM Account WHERE cpf=:cpf";
		Query query = getSession().createQuery(hql);
		query.setParameter("cpf", cpf);
		List<Account> resultAcc = query.list();
		
		if(!resultAcc.isEmpty()){
			hql = "DELETE FROM Transaction WHERE accountId=:accountId";
			query = getSession().createQuery(hql);
			query.setParameter("accountId", resultAcc.get(0));
			query.executeUpdate();			
		}					
		
		return true;
	}

}
