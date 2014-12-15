package com.ciandt.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue
	@Column(name="accountId")
	private Long accountId;
	
	@Column(name="agency")
	private String agency;
	
	@Column(name="account")
	private String account;
	
	@Column(name="cpf")
	private long cpf;
	
	@Column(name="clientName")
	private String clientName;
	
	@Column(name="balance")
	private double balance;
	
	@OneToMany(mappedBy="account", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Transaction> transactions;

	public Account(){
		transactions = new ArrayList<Transaction>();		
	}
	
	public Account(String agencia, String conta, long cpf, String nomeCliente, double balance){
		this.agency = agencia;
		this.account = conta;
		this.cpf = cpf;
		this.clientName = nomeCliente;
		this.balance = balance;		
	}

	public Long getAccountId() {
		return accountId;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return "Account=[agency="+this.agency+", account="+this.account+", cpf="+this.cpf+", "
				+ "clientName="+this.clientName+", balance="+this.balance+"]";
	}
}
