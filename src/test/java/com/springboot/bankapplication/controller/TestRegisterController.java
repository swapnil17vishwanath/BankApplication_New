package com.springboot.bankapplication.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import com.springboot.bankapplication.dto.CustomerRequestDto;
import com.springboot.bankapplication.dto.CustomerResponseDto;
import com.springboot.bankapplication.entity.Customer;
import com.springboot.bankapplication.entity.CustomerAccount;
import com.springboot.bankapplication.repository.RegisterRepository;
import com.springboot.bankapplication.service.RegisterService;

class TestRegisterController {
	RegisterController spy;

	@Mock
	RegisterService registerService;

	@Mock
	CustomerRequestDto customerRequestDto;
	
	@Mock
	CustomerResponseDto customerResponseDto;
	
	@Mock
	RegisterRepository registerRepository;
	
	@Mock
	CustomerAccount accountDetails;

	@BeforeEach
	void init() {
		spy = new RegisterController();
	}

	@Nested
	@DisplayName("registerCustomer")
	class registerCustomer {
		@Test
		void testregisterCustomer() {
			
			Customer customer = new Customer();
			
			customer.setFirstName("swap");;
			customer.setLastName("pacahre");;
			customer.setEmailID("swa.anrd@gmail.com");
			customer.setMobileNo("9975097301");
			customer.setArea("MH");
			customer.setCity("ngp");
			customer.setPincode("444908");
			customer.setState("MH");
			 
			ResponseEntity<Customer> ctr=ResponseEntity.ok(customer);
			//when(registerRepository.save(ResponseEntity<>)).thenReturn((List<Customer>) ctr);
			//when(registerRepository.save(Mockito.any())).thenReturn((List<Customer>)ctr);
			//when(registerRepository.save(Mockito.any())).thenReturn(ctr);
			assertEquals(registerService.registerCustomer(customerRequestDto), ctr);
//			spy.registerCustomer(new CustomerRequestDto());
			
//			assertEquals(spy.registerCustomer(customerRequestDto).ok(customerResponseDto), ctr);
		}

		@Test
		void testregisterCustomerfail() {
			Customer customer = new Customer();
			ResponseEntity<Customer> retval = ResponseEntity.ok(customer);
			assertNotNull(retval, "The registerCustomer method did not return the expected results");

		}
	}
}
