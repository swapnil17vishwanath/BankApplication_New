package com.springboot.bankapplication.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.FundTransferDto;
import com.springboot.bankapplication.service.FundTransferService;

@RestController
@RequestMapping("/fundtransfer")
public class FundTransferController {
	
	@Autowired
	private FundTransferService fundTransferService;
	
	
	
	@PostMapping
	public ResponseEntity<?> fundtransfer(@NotNull @RequestParam Long fromAccountNumber,@NotNull @RequestParam Long toAccountNumber,
			@NotNull @RequestParam double amount) {
			FundTransferDto fundTransferDto=  fundTransferService.fundtransfer(fromAccountNumber, toAccountNumber, amount);
			return new ResponseEntity<>(fundTransferDto, HttpStatus.OK); 
	}
}
