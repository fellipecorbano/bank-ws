package com.ciandt.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class BaseDAO {
	
	SessionFactory sessionFactory;	
	
	@Resource
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory=sf;
	}	
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
}
