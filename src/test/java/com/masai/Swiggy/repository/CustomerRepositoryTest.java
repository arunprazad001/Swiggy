package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setCustomerId("12345");
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");

        Customer savedCustomer = customerRepository.save(customer);

        assertThat(savedCustomer).isNotNull();
        assertThat(savedCustomer.getCustomerId()).isNotNull();
    }

    @Test
    public void testFindCustomerById() {
        Customer customer = customerRepository.findByCustomerId("12345");

        assertThat(customer).isNotNull();
        assertThat(customer.getName()).isEqualTo("John Doe");
    }


}
