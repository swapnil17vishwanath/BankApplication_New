package com.springboot.bankapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.bankapplication.entity.Customer;

@Repository
public interface RegisterRepository extends JpaRepository<Customer, Long>{

}
