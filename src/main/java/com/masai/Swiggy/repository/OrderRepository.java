package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    Order findByOrderId(String orderId);
    List<Order> findByCustomerId(String customerId);
}
