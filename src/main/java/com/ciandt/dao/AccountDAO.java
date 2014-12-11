package com.ciandt.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ciandt.beans.Account;

@Repository
public class AccountDAO extends DAO{
	
	public Account addAccount(Account account){
		Session session = getCurrentSession();
		
		session.beginTransaction();
		session.save(new Account("0000012", "0001234567", 12345678901L, "Fellipe teste", 100000) );
		session.getTransaction().commit();
		session.close();
		
		return null;
	}
	
}
