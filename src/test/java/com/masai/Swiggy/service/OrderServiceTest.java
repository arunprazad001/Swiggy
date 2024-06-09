package com.masai.Swiggy.service;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order();
        order.setRestaurantId("12345");
        order.setOrderStatus("Placed");
        order.setDeliveryPartnerId("qwerty12345");

        when(orderRepository.save(any(Order.class))).thenReturn(order);

        orderService.placeOrder(order);

        verify(orderRepository, times(1)).save(order);
    }

}
