package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;


import static org.assertj.core.api.Assertions.assertThat;

public class OrderRepositoryTest {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderRepositoryTest(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setOrderId("123456");
        order.setOrderStatus("Placed");
        Order savedOrder = orderRepository.save(order);

        assertThat(savedOrder).isNotNull();
        assertThat(savedOrder.getOrderId()).isNotNull();
    }

    @Test
    public void testFindAllOrders() {
        List<Order> orders = orderRepository.findAll();
        assertThat(orders).isNotEmpty();
    }
}
