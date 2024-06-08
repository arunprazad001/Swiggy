package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class OrderDAO {
   private final OrderRepository orderRepository;

   @Autowired
    public OrderDAO(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(int pageNo, int pageSize, String sortBy) {
        List<Order> orders=orderRepository.findAll();
        return orders.stream()
                .sorted(Comparator.comparing(Order::getOrderStatus))
                .skip((pageNo-1)*pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());

    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Order findById(String orderId) {
      return orderRepository.findByOrderId(orderId);
    }

    public List<Order> findByCustomerId(String customerId) {
       return orderRepository.findByCustomerId(customerId);
    }
    public List<Order>getAllOrders(){
        return orderRepository.findAll();
    }
}
