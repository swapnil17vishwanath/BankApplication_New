package com.springboot.bankapplication.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.TransactionResponseDto;
import com.springboot.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/statement")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping
	public ResponseEntity<List<TransactionResponseDto>> monthlyStatement(@NotNull @RequestParam Long accountNumber,
			@NotNull @RequestParam String month,@NotNull @RequestParam String year) {
			List<TransactionResponseDto> detailsResponseDtos = transactionService.monthlyStatement(accountNumber,
					month, year);
			return new ResponseEntity<List<TransactionResponseDto>>(detailsResponseDtos, HttpStatus.OK);
	}
}
