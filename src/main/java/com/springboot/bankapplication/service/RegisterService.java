package com.springboot.bankapplication.service;

import com.springboot.bankapplication.dto.CustomerRequestDto;
import com.springboot.bankapplication.dto.CustomerResponseDto;

public interface RegisterService {

	CustomerResponseDto registerCustomer(CustomerRequestDto customerRequestDto);

}
