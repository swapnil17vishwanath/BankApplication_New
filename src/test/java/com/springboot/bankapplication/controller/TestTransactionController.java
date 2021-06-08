package com.springboot.bankapplication.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.springboot.bankapplication.dto.TransactionResponseDto;
import com.springboot.bankapplication.entity.CustomerAccount;
import com.springboot.bankapplication.repository.CustomerAccountRepository;
import com.springboot.bankapplication.service.TransactionService;

class TestTransactionController {

	TransactionController spy ;
	
	@Mock
	TransactionService transactionService;

	@Mock
	TransactionResponseDto transactionResponseDto;
	
	@Mock
	CustomerAccountRepository customerAccountRepository;
	
	@BeforeEach
	void init() {
		spy = new TransactionController();
	}
	
	@Nested
	@DisplayName("monthlyStatement")
	class monthlyStatement {
		@Test
		void testmonthlyStatement() {
			
			CustomerAccount customer = new CustomerAccount();
			
			customer.setAccountNumber(1234567890L);
			customer.setAccountType("Saving");
			customer.setAvailableBalance(200);
			ResponseEntity<CustomerAccount> ctr=ResponseEntity.ok(customer);
			
			transactionResponseDto.getAccountNumber();
			//when(customerAccountRepository.findByAccountNumber(1234567890L)).thenReturn(ctr);
			 
			assertEquals(spy.monthlyStatement(1234567890L, "MAY", "2009"), ctr);
			//assertEquals(customerAccountRepository., ctr);
			
		}

		@Test
		void testmonthlyStatementfail() {
			CustomerAccount customer = new CustomerAccount();
			ResponseEntity<CustomerAccount> retval = ResponseEntity.ok(customer);
			assertNotNull(retval, "The registerCustomer method did not return the expected results");

		}
	}

}
