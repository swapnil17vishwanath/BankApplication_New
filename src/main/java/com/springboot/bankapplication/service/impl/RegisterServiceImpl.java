package com.springboot.bankapplication.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankapplication.dto.CustomerRequestDto;
import com.springboot.bankapplication.dto.CustomerResponseDto;
import com.springboot.bankapplication.entity.Customer;
import com.springboot.bankapplication.entity.CustomerAccount;
import com.springboot.bankapplication.repository.RegisterRepository;
import com.springboot.bankapplication.service.RegisterService;
import com.springboot.bankapplication.util.BankUtility;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	CustomerAccount accountDetails = null;

	@Override
	public CustomerResponseDto registerCustomer(CustomerRequestDto customerRequestDto) {

		Customer customer = new Customer();

		BeanUtils.copyProperties(customerRequestDto, customer);

		accountDetails = new CustomerAccount();
		accountDetails.setAccountNumber(BankUtility.bankAccountNoCreator());
		accountDetails.setAccountType(customerRequestDto.getAccountType());
		accountDetails.setAvailableBalance(5000);
		accountDetails.setCustomer(customer);

		customer.setCustomerAccount(accountDetails);

		Customer createdCustomer = registerRepository.save(customer);

		CustomerResponseDto customerResponseDto = new CustomerResponseDto(createdCustomer.getFirstName(),
				createdCustomer.getLastName(), createdCustomer.getCity(), createdCustomer.getMobileNo(),
				createdCustomer.getCustomerAccount().getAccountNumber(),
				createdCustomer.getCustomerAccount().getAvailableBalance());

		return customerResponseDto;

	}

}
