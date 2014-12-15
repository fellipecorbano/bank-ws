package com.ciandt.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.ciandt.enumeration.TransactionType;

@Entity
@Table(name="transaction")
public class Transaction {

	@Id
	@GeneratedValue
	private Long transId;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	private TransactionType type;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category")
	private String category;
	
	@Column(name="amount")
	private double amount;	
	
	@ManyToOne
	@JoinColumn(name="accountId")	
	private Account account;
		
	public Transaction(){}
	
	public Transaction(TransactionType tipo, String descricao, String categoria, double amount){
		this.type = tipo;
		this.description = descricao;
		this.category = categoria;
		this.amount = amount;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
		
	@XmlTransient
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction=[transId="+this.transId+", type="+this.type.toString()+", description="+this.description+", "
				+ "category="+this.category+", amount="+this.amount+", account={"+this.account+"}]";
	}
	
}
