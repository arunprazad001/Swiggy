package com.masai.Swiggy.service;

import com.masai.Swiggy.dao.CustomerDAO;
import com.masai.Swiggy.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }

    public void addCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    public Customer getCustomerById(String customerId) {
        return customerDAO.findById(customerId);
    }

}
