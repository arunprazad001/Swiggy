package com.masai.Swiggy.service;

import com.masai.Swiggy.dao.RestaurantDAO;
import com.masai.Swiggy.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class RestaurantService {
    @Autowired
    private RestaurantDAO restaurantDAO;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDAO.findAll();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantDAO.save(restaurant);
    }

    public Restaurant getRestaurantById(String restaurantId) {
        return restaurantDAO.findById(restaurantId);
    }
}
