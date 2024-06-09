package com.masai.Swiggy.integration;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OrderIntegrationTest {



    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        order.setRestaurantId("12345");
        order.setOrderStatus("Placed");
        order.setDeliveryPartnerId("qwerty12345");

        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:8080" + "/orders/placeOrder", order, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        // Optionally, verify the order is in the database
        assertThat(orderRepository.findAll()).isNotEmpty();
    }

    @Test
    public void testGetAllOrders() {
        ResponseEntity<Order[]> response = restTemplate.getForEntity("http://localhost:8080" + "/orders/getAll", Order[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
    }


}
