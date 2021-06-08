package com.springboot.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CustomerAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountId;
	private Long accountNumber;
	private String accountType;
	private double availableBalance;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public CustomerAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerAccount(Long accountNumber, String accountType, double availableBalance, long customerId,
			Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.availableBalance = availableBalance;
		this.customer = customer;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerAccountDetails [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", availableBalance=" + availableBalance + ", Customer=" + customer + "]";
	}
	
	

}
