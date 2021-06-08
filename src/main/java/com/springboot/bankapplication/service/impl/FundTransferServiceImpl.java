package com.springboot.bankapplication.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.bankapplication.dto.FundTransferDto;
import com.springboot.bankapplication.entity.CustomerAccount;
import com.springboot.bankapplication.entity.Transaction;
import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.exception.InsufficientBalanceException;
import com.springboot.bankapplication.repository.CustomerAccountRepository;
import com.springboot.bankapplication.repository.TransactionRepository;
import com.springboot.bankapplication.service.FundTransferService;

@Service
@Transactional
public class FundTransferServiceImpl implements FundTransferService {

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public FundTransferDto fundtransfer(Long fromAccountNumber, Long toAccountNumber, double amount){
		
		if (fromAccountNumber.equals(toAccountNumber)) {
			throw new AccountNotFoundException("Sender can not transfer amount on same account number");
		}
		
		CustomerAccount fromAccountDetails = customerAccountRepository.findByAccountNumber(fromAccountNumber);
		if (fromAccountDetails == null) {
			throw new AccountNotFoundException("Sender Account Number is not valid");
		}
		if(fromAccountDetails.getAvailableBalance() < amount) {
			throw new InsufficientBalanceException("Sender has Insufficient Balance");
		}

		CustomerAccount toAccountDetails = customerAccountRepository.findByAccountNumber(toAccountNumber);
		if (toAccountDetails == null) {
			throw new AccountNotFoundException("Receiver Account Number is not valid");
		}
 
		double remainingBalance = 0;
		double creaditBalance = 0;

		if (fromAccountDetails.getAvailableBalance() >= amount) {

			remainingBalance = fromAccountDetails.getAvailableBalance() - amount;
			creaditBalance = toAccountDetails.getAvailableBalance() + amount;

			fromAccountDetails.setAvailableBalance(remainingBalance);
			toAccountDetails.setAvailableBalance(creaditBalance);

		}

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setTransactionDate(LocalDateTime.now());
		transaction.setDebitFrom(fromAccountNumber);
		transaction.setCreditTo(toAccountNumber);
		transactionRepository.save(transaction);

		return new FundTransferDto(fromAccountNumber, toAccountNumber, amount,
				"Rs." + amount + " Transfer Successfully to " + toAccountNumber,
				transaction.getTransactionDate());

	}

}
