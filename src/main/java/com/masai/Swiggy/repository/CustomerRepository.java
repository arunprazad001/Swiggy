package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer findByCustomerId(String customerId);
}
