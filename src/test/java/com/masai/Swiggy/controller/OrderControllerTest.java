package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Order;
import com.masai.Swiggy.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllOrders() throws Exception {
        when(orderService.getAllOrders(anyInt(), anyInt(), anyString())).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

        verify(orderService, times(1)).getAllOrders(anyInt(), anyInt(), anyString());
    }

    @Test
    public void testPlaceOrder() throws Exception {
        Order order = new Order();
        order.setRestaurantId("12345");
        order.setOrderStatus("Placed");
        order.setDeliveryPartnerId("qwerty12345");

        mockMvc.perform(post("/orders/placeOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{/* JSON representation of the order */}"))
                .andExpect(status().isCreated());

        verify(orderService, times(1)).placeOrder(any(Order.class));
    }


}
