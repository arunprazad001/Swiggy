package com.masai.Swiggy.integration;

import com.masai.Swiggy.entity.Customer;
import com.masai.Swiggy.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerIntegrationTest {



    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();

        customer.setCustomerId("12345");
        customer.setName("John Smith");
        customer.setEmail("john.smith@example.com");

        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:8080"  + "/customers", customer, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        assertThat(customerRepository.findAll()).isNotEmpty();
    }

    @Test
    public void testGetCustomer() {
        ResponseEntity<Customer> response = restTemplate.getForEntity("http://localhost:8080"  + "/customers/12345", Customer.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("John Smith");
    }


}
