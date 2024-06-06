package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Customer;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class CustomerDAO {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> findAll() {
        return customers;
    }

    public void save(Customer customer) {
        customers.add(customer);
    }

    public Customer findById(String customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId().equals(customerId))
                .findFirst()
                .orElse(null);
    }
}
