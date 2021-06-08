package com.springboot.bankapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bankapplication.dto.CustomerRequestDto;
import com.springboot.bankapplication.dto.CustomerResponseDto;
import com.springboot.bankapplication.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired 
	private RegisterService registerService;

	@PostMapping
	public ResponseEntity<CustomerResponseDto> registerCustomer(
			@Valid @RequestBody CustomerRequestDto customerRequestDto) {

		CustomerResponseDto newCreatedCustomer = registerService.registerCustomer(customerRequestDto);
		return new ResponseEntity<CustomerResponseDto>(newCreatedCustomer, HttpStatus.CREATED);

	}

}
