package com.ciandt.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DAO {
	
	@Autowired
	SessionFactory sessionFactory;	
		
	protected Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}		
	
}
