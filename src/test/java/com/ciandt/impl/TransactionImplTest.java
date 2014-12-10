package com.ciandt.impl;

import org.junit.Test;

import com.ciandt.beans.Transaction;
import com.ciandt.dao.DAOMock;
import com.ciandt.enumeration.transType;
import com.ciandt.util.JunitSpringTestUtil;

public class TransactionImplTest extends JunitSpringTestUtil {

	public DAOMock bm;	
	public TransactionImpl aImpl;
	
	@Test
	public void testAddTransaction() {
				
		Transaction trans1 = new Transaction(transType.INCOME, "Receita 1", "SAL�RIO", 1000);
		Transaction trans2 = new Transaction(transType.INCOME, "Receita 2", "SAL�RIO", 2000);
		Transaction trans3 = new Transaction(transType.EXPENSE, "Despesa 1", "ALIMENTA��O", 10);
		Transaction trans4 = new Transaction(transType.EXPENSE, "Despesa 2", "ALUGUEL", 500);
		Transaction trans5 = new Transaction(transType.EXPENSE, "Despesa 3", "ALIMENTA��O", 18);
		
		long cpf1 = 12345678901L;
		long cpf2 = 12345678902L;
		
		//tImpl.addTransaction(cpf1, trans1);
		//tImpl.addTransaction(cpf1, trans3);
		//tImpl.addTransaction(cpf1, trans4);
		
		//tImpl.addTransaction(cpf2, trans2);
		//tImpl.addTransaction(cpf2, trans5);
		
		// Verify if the transaction exists in transaction list of his account
		
	}

	@Test
	public void testListTransactions() {
		//fail("Not yet implemented");
	}

}
