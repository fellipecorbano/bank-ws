package com.ciandt.tests;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.beans.Account;
import com.ciandt.services.AccountService;
import com.ciandt.tests.util.JunitSpringTestUtil;

public class AccountServiceTest extends JunitSpringTestUtil {

	@Autowired
	public AccountService aService;
	
	public static Long[] cpf;
	public static Account[] account;
	
	@BeforeClass
	public static void init(){
		cpf = new Long[]{12345678111L, 12345678222L, 12345678333L,	99999999999L, 11111111111L};
				
		Account c1 = new Account("0001", "01230123", cpf[0], "João da Silva", 12000);		
		Account c2 = new Account("0002", "04560456", cpf[1], "Maurício de Souza", 15478);		
		Account c3 = new Account("0003", "07890789", cpf[2], "Alessandro Reis", 4567894.40);
		Account c4 = new Account("0004", "04521852", cpf[3], "Victor Dias", 45137.50);
		account = new Account[]{c1, c2, c3, c4};
	}
	
	@Test
	public void testAddAccount() {
		aService.addAccount(account[0]);
		aService.addAccount(account[1]);
		
		Account a1 = aService.getAccountByCPF(cpf[0]);
		assertThat(account[0].getAccount(), is(a1.getAccount()));
		assertThat(account[0].getAgency(), is(a1.getAgency()));
		assertThat(account[0].getCpf(), is(a1.getCpf()));
		assertThat(account[0].getClientName(), is(a1.getClientName()));
		assertThat(account[0].getBalance(), is(a1.getBalance()));
		
		Account a2 = aService.getAccountByCPF(cpf[1]);
		assertThat(account[1].getAccount(), is(a2.getAccount()));
		assertThat(account[1].getAgency(), is(a2.getAgency()));
		assertThat(account[1].getCpf(), is(a2.getCpf()));
		assertThat(account[1].getClientName(), is(a2.getClientName()));
		assertThat(account[1].getBalance(), is(a2.getBalance()));		
	}
	
	@Test
	public void testGetAccountByCPF() {
		aService.addAccount(account[2]);
		aService.addAccount(account[3]);
		
		Account a1 = aService.getAccountByCPF(cpf[2]);
		Account a2 = aService.getAccountByCPF(cpf[3]);
		Account a3 = aService.getAccountByCPF(cpf[4]);
		
		assertNotNull(a1);
		assertNotNull(a2);
		assertNull(a3);
	}	

	@Test
	public void testRemoveAccountByCPF() {
		Account a1 = aService.getAccountByCPF(cpf[0]);
		Account a2 = aService.getAccountByCPF(cpf[1]);
		Account a3 = aService.getAccountByCPF(cpf[2]);
		Account a4 = aService.getAccountByCPF(cpf[3]);
		
		assertNotNull(a1);
		assertNotNull(a2);
		assertNotNull(a3);
		assertNotNull(a4);
		
		aService.removeAccountByCPF(a1.getCpf());
		aService.removeAccountByCPF(a2.getCpf());
		aService.removeAccountByCPF(a3.getCpf());
		aService.removeAccountByCPF(a4.getCpf());
		
		a1 = aService.getAccountByCPF(cpf[0]);
		a2 = aService.getAccountByCPF(cpf[1]);
		a3 = aService.getAccountByCPF(cpf[2]);
		a4 = aService.getAccountByCPF(cpf[3]);
		
		assertNull(a1);
		assertNull(a2);
		assertNull(a3);
		assertNull(a4);
	}

}
