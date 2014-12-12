package com.ciandt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ciandt.beans.Account;
import com.ciandt.beans.Transaction;
import com.ciandt.enumeration.transType;

@Repository
public class DAOMock {

	@Autowired
	AccountDAO accountDAOWired;
	
	public static AccountDAO accountDAO;
	
	@PostConstruct
	public void init(){
		DAOMock.accountDAO = accountDAOWired;
	}
	
	public static Map<Long, Account> lsAccounts;
	
	public static Map<Long, Account> getAccountsMock(){
		
		if(lsAccounts==null)
			mockDatabase();
		 
		return lsAccounts;	
	}		
		
	
	/*********************************************
	* Mock Database
	*********************************************/
	public static void mockDatabase() {
		lsAccounts = new HashMap<Long, Account>();		
		
		lsAccounts.put(12345678901L, new Account("0001", "0016348", 12345678901L, "Fellipe", 10500));
		lsAccounts.put(12345678902L, new Account("0001", "0006834", 12345678902L, "João", 20600));
		lsAccounts.put(12345678903L, new Account("0002", "0000455", 12345678903L, "Maria", 30100));
		lsAccounts.put(12345678904L, new Account("0002", "0000023", 12345678904L, "Raphael", 43000));
		lsAccounts.put(12345678905L, new Account("0002", "0303005", 12345678905L, "Diego", 50670));
		lsAccounts.put(12345678906L, new Account("0003", "0404006", 12345678906L, "Fabio", 60320));
		lsAccounts.put(12345678907L, new Account("0003", "0004707", 12345678907L, "Odair", 74500));
		lsAccounts.put(12345678908L, new Account("0003", "0000408", 12345678908L, "Giovani", 89000));
		lsAccounts.put(12345678909L, new Account("0003", "0040009", 12345678909L, "Andre", 90560));
		lsAccounts.put(12345678910L, new Account("0003", "0087659", 12345678910L, "Marcio", 160970));
		
	}
	
	
	/*********************************************
	* Account Mock DAO
	*********************************************/
	public static boolean accountExists(long cpf){
		return lsAccounts.containsKey(cpf);		
	}
	
	public static Account addAccount(Account c){
		lsAccounts.put(c.getCpf(), c);		
		
		accountDAO.addAccount(c);
		
		return c;		
	}
	
	public static boolean removeAccount(long cpf) {
				
		if(accountExists(cpf)){
			lsAccounts.remove(cpf);
			return true;
		}	
		return false;
	}

		
	/*********************************************
	* Transaction Mock DAO
	*********************************************/
	public static boolean addTransaction(long cpf, Transaction transaction) {
		
		Account c = getAccountsMock().get(cpf);
		
		if(!(c==null)){
			
		
			if(transaction.getType().equals(transType.INCOME)){
				c.setBalance(c.getBalance() + transaction.getAmount());
			}else if(transaction.getType().equals(transType.EXPENSE)){
				c.setBalance(c.getBalance() - transaction.getAmount());
			}else{
				return false;
			}
			
			if(c.getTransactions()==null){
				List<Transaction> transactions = new ArrayList<Transaction>();
				transactions.add(transaction);
				c.setTransactions(transactions);				
			}else{
				c.getTransactions().add(transaction);
			}
				
			return true;
		}
		
		return false;			
	}

	public static List<Transaction> listTransactions(long cpf) {
			
		Account c = getAccountsMock().get(cpf);
		if(!(c==null))
			return c.getTransactions();							
		
		return null;		
	}
	
}
