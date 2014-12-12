package com.ciandt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDAO {
	
	SessionFactory sessionFactory;	
	
	@Autowired
	public SessionFactory setSessionFactory(SessionFactory sessionFactory){
		return this.sessionFactory = sessionFactory;
	}
	
	protected Session getCurrentSession(){
		//return sessionFactory.getCurrentSession();
		return sessionFactory.openSession();
	}		
	
}
