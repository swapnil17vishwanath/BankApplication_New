package com.springboot.bankapplication.service;

import java.util.List;

import com.springboot.bankapplication.dto.TransactionResponseDto;

public interface TransactionService {
	List<TransactionResponseDto> monthlyStatement(Long accountNumber, String month, String year);
}
