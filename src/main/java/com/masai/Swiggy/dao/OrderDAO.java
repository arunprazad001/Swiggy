package com.masai.Swiggy.dao;
import com.masai.Swiggy.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class OrderDAO {
    private List<Order> orders = new ArrayList<>();

    public List<Order> findAll() {
        return orders;
    }

    public void save(Order order) {
        orders.add(order);
    }

    public Order findById(String orderId) {
        return orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .findFirst()
                .orElse(null);
    }

    public List<Order> findByCustomerId(String customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId().equals(customerId)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
}
