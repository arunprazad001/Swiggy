package com.masai.Swiggy.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    @NotBlank(message = "Customer ID is required")
    private String customerId;

    @NotBlank(message = "Restaurant ID is required")
    private String restaurantId;

    private String deliveryPartnerId;

    @NotNull(message = "Items cannot be null")
    private List<String> items;

    @NotBlank(message = "Order status is required")
    private String orderStatus;
}
