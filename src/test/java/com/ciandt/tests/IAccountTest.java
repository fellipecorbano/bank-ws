package com.ciandt.tests;

import javax.xml.ws.Endpoint;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ciandt.interfaces.IAccount;
import com.ciandt.util.JunitSpringTestUtil;

public class IAccountTest extends JunitSpringTestUtil{

	public Endpoint endpoint;
	
	@Autowired
	public IAccount accountWebService;
	
	@Before
	public void publish(){
		
		try{
			endpoint = Endpoint.create(accountWebService);
			endpoint.publish("http://127.0.0.1:8099/MyWebApp/AccountWebService");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAccountByCPF() {
		//fail("Not yet implemented");
	}

	@Test
	public void testAddAccount() {
		//fail("Not yet implemented");
	}

	@Test
	public void testRemoveAccountByCPF() {
		//fail("Not yet implemented");
	}
	
	@After
	public void unpublish(){
		if(endpoint!=null)
			endpoint.stop();
	}

}
