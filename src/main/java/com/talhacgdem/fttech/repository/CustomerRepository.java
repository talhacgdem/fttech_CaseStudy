package com.talhacgdem.fttech.repository;

import com.talhacgdem.fttech.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
