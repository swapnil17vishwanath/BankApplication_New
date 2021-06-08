package com.springboot.bankapplication.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapplication.dto.TransactionResponseDto;
import com.springboot.bankapplication.entity.CustomerAccount;
import com.springboot.bankapplication.entity.Transaction;
import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.repository.CustomerAccountRepository;
import com.springboot.bankapplication.repository.TransactionRepository;
import com.springboot.bankapplication.service.TransactionService;
import com.springboot.bankapplication.util.BankUtility;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private CustomerAccountRepository customerAccountRepository;

	@Override
	public List<TransactionResponseDto> monthlyStatement(Long accountNumber, String month, String year) {

		CustomerAccount getAccount = customerAccountRepository.findByAccountNumber(accountNumber);

		if (getAccount == null) {
			throw new AccountNotFoundException("Account Number is not valid");
		}

		List<TransactionResponseDto> detailsResponseDtos = new ArrayList<TransactionResponseDto>();

		/*
		 * Converting in date format
		 */
		List<LocalDateTime> dateList = BankUtility.convertMonthIntoDate(month, year);

		LocalDateTime endDate = dateList.get(0);
		LocalDateTime startDate = dateList.get(1);

		List<Transaction> listOfTransaction = transactionRepository
				.findByTransactionDateBetween(startDate, endDate);

		for (Transaction details : listOfTransaction) {

			TransactionResponseDto responseDto = new TransactionResponseDto();

			if (accountNumber.toString().equals(details.getCreditTo().toString())
					|| accountNumber.toString().equals(details.getDebitFrom().toString())) {

				responseDto.setAccountNumber(accountNumber);
				responseDto.setAmount(details.getAmount());
				responseDto.setTransactionDate(details.getTransactionDate());
				if (accountNumber.toString().equals(details.getCreditTo().toString())) {
					responseDto.setCreditFrom(details.getDebitFrom());
					responseDto.setDebitTo(0L);
				}
				if (accountNumber.toString().equals(details.getDebitFrom().toString())) {
					responseDto.setDebitTo(details.getCreditTo());
					responseDto.setCreditFrom(0L);
				}

				detailsResponseDtos.add(responseDto);
			}

		}

		return detailsResponseDtos;
		
	}

}
