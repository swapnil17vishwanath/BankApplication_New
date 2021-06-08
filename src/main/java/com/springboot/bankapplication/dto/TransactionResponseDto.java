package com.springboot.bankapplication.dto;

import java.time.LocalDateTime;

public class TransactionResponseDto {

	private Long accountNumber;
	private double amount;
	private LocalDateTime transactionDate;
	private Long creditFrom;
	private Long debitTo;

	public TransactionResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransactionResponseDto(Long accountNumber, String process, double amount, LocalDateTime transactionDate,
			Long creditFrom, Long debitTo) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.transactionDate = transactionDate;
		this.creditFrom = creditFrom;
		this.debitTo = debitTo;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getCreditFrom() {
		return creditFrom;
	}

	public void setCreditFrom(Long creditFrom) {
		this.creditFrom = creditFrom;
	}

	public Long getDebitTo() {
		return debitTo;
	}

	public void setDebitTo(Long debitTo) {
		this.debitTo = debitTo;
	}

}
