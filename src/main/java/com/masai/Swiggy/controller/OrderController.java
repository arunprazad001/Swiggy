package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.OrderService;
import jakarta.validation.Valid;
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

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/placeOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public void placeOrder(@Valid @RequestBody Order order) {
        orderService.placeOrder(order);
    }

    @PutMapping("/{orderId}/assign/{deliveryPartnerId}")
    public void assignDeliveryPartner(@PathVariable String orderId, @PathVariable String deliveryPartnerId) {
        orderService.assignDeliveryPartner(orderId, deliveryPartnerId);
    }

    @PutMapping("update/{orderId}/status")
    public void updateOrderStatus(@PathVariable String orderId, @RequestParam String status) {
        orderService.updateOrderStatus(orderId, status);
    }
}