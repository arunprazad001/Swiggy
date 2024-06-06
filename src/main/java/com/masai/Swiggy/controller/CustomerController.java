package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.CustomerService;
import com.masai.Swiggy.service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@Valid  @RequestBody Customer customer) {
        logger.info("Received request to create customer:{}",customer);
        customerService.addCustomer(customer);
    }

    @GetMapping("get/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @GetMapping("get/{id}/orders")
    public List<Order> getCustomerOrderHistory(@PathVariable String id) {
        return orderService.getCustomerOrderHistory(id);
    }
}
