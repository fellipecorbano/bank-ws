package com.ciandt.tests;

import javax.xml.ws.Endpoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.interfaces.ITransaction;

public class ITransactionTest {

public Endpoint endpoint;
	
	@Autowired
	public ITransaction transactionWebService;
		
	@Before
	public void publish(){
		
		try{
			//endpoint = Endpoint.create(transactionWebService);
			//endpoint.publish("http://127.0.0.1:8099/MyWebApp/TransactionWebService");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddTransaction() {
		//fail("Not yet implemented");
	}

	@Test
	public void testListTransactions() {
		//fail("Not yet implemented");
	}
	
	@After
	public void unpublish(){
		if(endpoint!=null)
			endpoint.stop();
	}

}
