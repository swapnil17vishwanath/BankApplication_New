package com.springboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankapplication.entity.CustomerAccount;
@Repository
public interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {

	CustomerAccount findByAccountNumber(Long fromAccountNo);

}
