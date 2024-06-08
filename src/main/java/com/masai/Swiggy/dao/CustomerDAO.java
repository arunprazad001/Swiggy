package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerDAO {

    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerDAO(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(int pageNo,int pageSize,String sortBy) {
        List<Customer>customers=customerRepository.findAll();
        Comparator<Customer> comparator;
        switch (sortBy){
            case "name":
                comparator=Comparator.comparing(Customer::getName);
                break;
            case"email":
                comparator=Comparator.comparing(Customer::getEmail);
                break;
            default:
                comparator=Comparator.comparing(Customer::getName);
                break;
        }
        return customers.stream()
                .sorted(comparator)
                .skip((pageNo-1)*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findById(String customerId) {
       return customerRepository.findByCustomerId(customerId);
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
