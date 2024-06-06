package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class RestaurantDAO {
    private List<Restaurant> restaurants = new ArrayList<>();

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public void save(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public Restaurant findById(String restaurantId) {
        return restaurants.stream()
                .filter(r -> r.getRestaurantId().equals(restaurantId))
                .findFirst()
                .orElse(null);
    }
}
