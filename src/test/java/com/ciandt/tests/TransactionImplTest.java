package com.ciandt.tests;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.beans.Account;
import com.ciandt.beans.Transaction;
import com.ciandt.dao.DAOMock;
import com.ciandt.enumeration.transType;
import com.ciandt.impl.AccountImpl;
import com.ciandt.impl.TransactionImpl;
import com.ciandt.util.JunitSpringTestUtil;

public class TransactionImplTest extends JunitSpringTestUtil {

	@Autowired
	public AccountImpl aImpl;
	
	@Autowired
	public TransactionImpl tImpl;
	
	@Test
	public void testAddTransaction() {
				
		// Accounts CPF
		long cpf1 = 12345678901L;
		long cpf2 = 12345678902L;		
		
		double balanceAccount1 = aImpl.getAccountByCPF(cpf1).getBalance();
		double balanceAccount2 = aImpl.getAccountByCPF(cpf2).getBalance();
		
		// Transactions to be added
		Transaction trans1 = new Transaction(transType.INCOME, "Receita 1", "SALÁRIO", 1000);
		Transaction trans2 = new Transaction(transType.INCOME, "Receita 2", "SALÁRIO", 2000);
		Transaction trans3 = new Transaction(transType.EXPENSE, "Despesa 1", "ALIMENTAÇÃO", 10);
		Transaction trans4 = new Transaction(transType.EXPENSE, "Despesa 2", "ALUGUEL", 500);
		Transaction trans5 = new Transaction(transType.EXPENSE, "Despesa 3", "ALIMENTAÇÃO", 18);
					
		// Add transactions
		tImpl.addTransaction(cpf1, trans1);
		assertThat(aImpl.getAccountByCPF(cpf1).getBalance(), is(balanceAccount1+1000));		
		tImpl.addTransaction(cpf1, trans3);
		assertThat(aImpl.getAccountByCPF(cpf1).getBalance(), is(balanceAccount1+1000-10));
		tImpl.addTransaction(cpf1, trans4);
		assertThat(aImpl.getAccountByCPF(cpf1).getBalance(), is(balanceAccount1+1000-10-500));
		
		tImpl.addTransaction(cpf2, trans2);
		assertThat(aImpl.getAccountByCPF(cpf2).getBalance(), is(balanceAccount2+2000));
		tImpl.addTransaction(cpf2, trans5);
		assertThat(aImpl.getAccountByCPF(cpf2).getBalance(), is(balanceAccount2+2000-18));
		
		// Verify if the transaction exists in transaction list of his account
		Account acc1 = DAOMock.getAccountsMock().get(cpf1);
		Account acc2 = DAOMock.getAccountsMock().get(cpf2);
		
		assertTrue(acc1.getTransactions().contains(trans1));
		assertTrue(acc1.getTransactions().contains(trans3));
		assertTrue(acc1.getTransactions().contains(trans4));
		
		assertTrue(acc2.getTransactions().contains(trans2));
		assertTrue(acc2.getTransactions().contains(trans5));	
		
	}

	@Test
	public void testListTransactions() {
		long cpf1 = 12345678901L;
		
		assertNull(tImpl.listTransactions(cpf1));
		
		Transaction trans1 = new Transaction(transType.INCOME, "Receita 1", "SALÁRIO", 1000);
		Transaction trans2 = new Transaction(transType.EXPENSE, "Despesa 1", "ALIMENTAÇÃO", 2000);
		
		tImpl.addTransaction(cpf1, trans1);
		tImpl.addTransaction(cpf1, trans2);
				
		assertNotNull(tImpl.listTransactions(cpf1));
		
	}

}
