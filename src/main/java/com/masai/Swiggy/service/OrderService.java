package com.masai.Swiggy.service;
import com.masai.Swiggy.dao.CustomerDAO;
import com.masai.Swiggy.dao.DeliveryPartnerDAO;
import com.masai.Swiggy.dao.OrderDAO;
import com.masai.Swiggy.dao.RestaurantDAO;
import com.masai.Swiggy.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private RestaurantDAO restaurantDAO;

    @Autowired
    private DeliveryPartnerDAO deliveryPartnerDAO;

    public List<Order> getAllOrders(int pageNo, int pageSize, String sortBy) {
        return orderDAO.findAll(pageNo,pageSize,sortBy);
    }

    public void placeOrder(Order order) {
        if (customerDAO.findById(order.getCustomerId()) == null) {
            throw new IllegalArgumentException("Customer ID not found");
        }
        if (restaurantDAO.findById(order.getRestaurantId()) == null) {
            throw new IllegalArgumentException("Restaurant ID not found");
        }
        orderDAO.save(order);
    }

    public void assignDeliveryPartner(String orderId, String deliveryPartnerId) {
        Order order = orderDAO.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order ID not found");
        }
        if (deliveryPartnerDAO.findById(deliveryPartnerId) == null) {
            throw new IllegalArgumentException("Delivery Partner ID not found");
        }
        if (order.getDeliveryPartnerId() != null) {
            throw new IllegalArgumentException("Delivery Partner already assigned");
        }
        order.setDeliveryPartnerId(deliveryPartnerId);
    }

    public void updateOrderStatus(String orderId, String status) {
        Order order = orderDAO.findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Order ID not found");
        }
        if ("delivered".equals(order.getOrderStatus())) {
            throw new IllegalArgumentException("Cannot update status of a delivered order");
        }
        order.setOrderStatus(status);
    }

    public List<Order> getCustomerOrderHistory(String customerId) {
        if (customerDAO.findById(customerId) == null) {
            throw new IllegalArgumentException("Customer ID not found");
        }
        return orderDAO.findByCustomerId(customerId);
    }

    public List<Order> getAllOrders(){
        return orderDAO.getAllOrders();
    }
}
