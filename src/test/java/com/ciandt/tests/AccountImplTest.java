package com.ciandt.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.beans.Account;
import com.ciandt.dao.DAOMock;
import com.ciandt.impl.AccountImpl;
import com.ciandt.util.JunitSpringTestUtil;

public class AccountImplTest extends JunitSpringTestUtil {

	@Autowired
	public AccountImpl aImpl;
		
	@Test
	public void testGetAccountByCPF() {
						
		Account c1 = aImpl.getAccountByCPF(12345678901L);
		Account c2 = aImpl.getAccountByCPF(12345678903L);
		Account c3 = aImpl.getAccountByCPF(12345678907L);
		
		Account c4 = aImpl.getAccountByCPF(99999999999L);
		Account c5 = aImpl.getAccountByCPF(11111111111L);
		
		assertNotNull(c1);
		assertNotNull(c2);
		assertNotNull(c3);
		
		assertNull(c4);
		assertNull(c5);
	}

	@Test
	public void testAddAccount() {
		 	 		
		Account c1 = new Account("0001", "01230123", 12345678111L, "João da Silva", 12000);
		Account c2 = new Account("0002", "04560456", 12345678222L, "Maurício de Souza", 15478);
		Account c3 = new Account("0003", "07890789", 12345678333L, "Alessandro Reis", 4567894.40);
		
		aImpl.addAccount(c1);
		aImpl.addAccount(c2);
		aImpl.addAccount(c3);
		
		assertTrue(DAOMock.accountExists(c1.getCpf()));
		assertTrue(DAOMock.accountExists(c2.getCpf()));
		assertTrue(DAOMock.accountExists(c3.getCpf()));
	}

	@Test
	public void testRemoveAccountByCPF() {
				
		long cpf1 = 12345678111L;
		long cpf2 = 12345678222L;
		long cpf3 = 12345678333L;
		long cpf4 = 99999999999L;
				
		aImpl.removeAccountByCPF(cpf1);
		aImpl.removeAccountByCPF(cpf2);
		aImpl.removeAccountByCPF(cpf3);
		aImpl.removeAccountByCPF(cpf4);
		
		assertFalse(DAOMock.accountExists(cpf1));
		assertFalse(DAOMock.accountExists(cpf2));
		assertFalse(DAOMock.accountExists(cpf3));
		assertFalse(DAOMock.accountExists(cpf4));
	}

}
