package com.springboot.bankapplication.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.springboot.bankapplication.dto.FundTransferDto;
import com.springboot.bankapplication.exception.AccountNotFoundException;
import com.springboot.bankapplication.repository.CustomerAccountRepository;
import com.springboot.bankapplication.repository.RegisterRepository;
import com.springboot.bankapplication.repository.TransactionRepository;
import com.springboot.bankapplication.service.FundTransferService;

@ExtendWith(MockitoExtension.class)
class TestFundTransferController {
	FundTransferController cut;
	
	@Mock
	FundTransferService fundTransferService;
	
	@Mock 
	CustomerAccountRepository customerAccountRepository ;
	
	@Mock
	RegisterRepository  registerRepository;
	
	@Mock 
	TransactionRepository transactionRepository;
	
	@Mock
	FundTransferDto fundTransferDto;
	
	@BeforeEach
	void init() {
		cut = new FundTransferController();
	}
	
	@Nested
	@DisplayName("fundtransfer")
	class fundtransfer {
 		@Test
		void testfundtransfer() {
			fundTransferDto = new FundTransferDto(286677242L,286677245L,200, "success", LocalDateTime.now());
			//spy.fundtransfer(286677242L,286677245L,200); 
			//ResponseEntity<FundTransferDto> f=
			when(cut.fundtransfer(286677242L,286677245L,200)).then((Answer<?>) fundTransferDto).thenThrow(new Exception());
			assertEquals(cut.fundtransfer(286677242L,286677245L,200), fundTransferDto);
			//assertEquals(fundTransferService, fundTransferDto);
//			when(deviceRepository.save(Mockito.any())).thenReturn(tmp);
//			assertEquals(cut.createDevice(1L, new Device()), Long.valueOf(1l));
		}

		@Test
		void testfundtransferfail() {
			//spy.fundtransfer(286677242L,286677245L,200);
			when(fundTransferService.fundtransfer(286677242L,286677245L,200)).thenReturn(fundTransferDto).thenThrow(AccountNotFoundException.class);
			assertNull(cut.fundtransfer(286677242L,286677245L,200));
		
		}
	}
}
