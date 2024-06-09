package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("12345");
        customer.setName("Jane Doe");
        customer.setEmail("jane.doe@example.com");

        when(customerService.createCustomer(any(Customer.class))).thenReturn(customer);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Jane Doe\", \"email\":\"jane.doe@example.com\"}"))
                .andExpect(status().isCreated());

        verify(customerService, times(1)).createCustomer(any(Customer.class));
    }

    @Test
    public void testGetCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setCustomerId("12345");
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        when(customerService.getCustomerById("12345")).thenReturn(customer);

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk());

        verify(customerService, times(1)).getCustomerById("12345");
    }


}
