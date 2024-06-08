package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @GetMapping("/getAll")
    public List<Order> getAllOrders(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "status") String sortBy) {
        logger.info("Fetching all orders based on parameters pageNo :{} pageSize: {} " +
                "and sortBy :{}",page,size,sortBy);
        return orderService.getAllOrders(page,size,sortBy);
    }

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@Valid @RequestBody Order order) {
        logger.info("request received to place order :{}",order);
        orderService.placeOrder(order);
    }

    @PutMapping("/{orderId}/assign/{deliveryPartnerId}")
    public void assignDeliveryPartner(@PathVariable String orderId, @PathVariable String deliveryPartnerId) {
        logger.info("request received to assign order for orderId: {} with delivery partnerId :{}",orderId,deliveryPartnerId);
        orderService.assignDeliveryPartner(orderId, deliveryPartnerId);
    }

    @PutMapping("update/{orderId}/status")
    public void updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        logger.info("request received to update order status of order:{} with order status:{}",orderId,status);
        orderService.updateOrderStatus(orderId, status);
    }
}