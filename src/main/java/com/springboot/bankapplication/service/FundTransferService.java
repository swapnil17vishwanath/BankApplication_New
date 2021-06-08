package com.springboot.bankapplication.service;

import com.springboot.bankapplication.dto.FundTransferDto;

public interface FundTransferService {
	
	FundTransferDto fundtransfer(Long fromAccountNumber,Long toAccountNumber,double amount);
}
