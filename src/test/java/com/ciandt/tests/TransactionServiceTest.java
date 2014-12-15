package com.ciandt.tests;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.beans.Account;
import com.ciandt.beans.Transaction;
import com.ciandt.enumeration.TransactionType;
import com.ciandt.services.AccountService;
import com.ciandt.services.TransactionService;
import com.ciandt.tests.util.JunitSpringTestUtil;

public class TransactionServiceTest extends JunitSpringTestUtil {

	@Autowired
	TransactionService tService;
	
	@Autowired
	AccountService aService;
		
	public static Long cpf;
	public static Account account;
	public static Transaction[] transaction;
	
	@BeforeClass
	public static void init(){
		cpf = 12345678111L;		
		account = new Account("0001", "01230123", cpf, "João da Silva", 12000);	
		
		Transaction t1 = new Transaction(TransactionType.INCOME, "Receita 1", "SALÁRIO", 1000);
		Transaction t2 = new Transaction(TransactionType.INCOME, "Receita 2", "SALÁRIO", 2000);
		Transaction t3 = new Transaction(TransactionType.EXPENSE, "Despesa 1", "ALIMENTAÇÃO", 10);
		Transaction t4 = new Transaction(TransactionType.EXPENSE, "Despesa 2", "ALUGUEL", 500);
		Transaction t5 = new Transaction(TransactionType.EXPENSE, "Despesa 3", "ALIMENTAÇÃO", 18);
		
		transaction = new Transaction[]{t1, t2, t3, t4, t5};		
	}
	
	@Test
	public void testAddTransaction() {
		
		aService.addAccount(account);
		
		double initialBalance = aService.getAccountByCPF(cpf).getBalance();
		
		assertTrue(tService.addTransaction(cpf, transaction[0]));
		assertThat(aService.getAccountByCPF(cpf).getBalance(), is(initialBalance+1000));
		
		assertTrue(tService.addTransaction(cpf, transaction[1]));
		assertThat(aService.getAccountByCPF(cpf).getBalance(), is(initialBalance+1000+2000));
		
		assertTrue(tService.addTransaction(cpf, transaction[2]));
		assertThat(aService.getAccountByCPF(cpf).getBalance(), is(initialBalance+1000+2000-10));
		
		assertTrue(tService.addTransaction(cpf, transaction[3]));
		assertThat(aService.getAccountByCPF(cpf).getBalance(), is(initialBalance+1000+2000-10-500));
		
		assertTrue(tService.addTransaction(cpf, transaction[4]));
		assertThat(aService.getAccountByCPF(cpf).getBalance(), is(initialBalance+1000+2000-10-500-18));					
		
		tService.removeTransactions(cpf);		
		aService.removeAccountByCPF(cpf);
	}

	@Test
	public void testListTransaction() {
		aService.addAccount(account);
		
		assertNull(tService.listTransactions(cpf));
				
		tService.addTransaction(cpf, transaction[0]);
		tService.addTransaction(cpf, transaction[3]);
				
		assertNotNull(tService.listTransactions(cpf));
		
		tService.removeTransactions(cpf);		
		aService.removeAccountByCPF(cpf);
	}

}
