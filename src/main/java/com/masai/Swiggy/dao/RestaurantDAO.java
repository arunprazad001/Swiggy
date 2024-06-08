package com.masai.Swiggy.dao;

import com.masai.Swiggy.entity.Restaurant;
import com.masai.Swiggy.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class RestaurantDAO {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantDAO(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll(int pageNo, int pageSize, String sortBy) {
        List<Restaurant>restaurants=restaurantRepository.findAll();
        Comparator<Restaurant> comparator;
        switch (sortBy) {
            case "name":
                comparator = Comparator.comparing(Restaurant::getName);
                break;
            case "address":
                comparator = Comparator.comparing(Restaurant::getAddress);
                break;
            default:
                comparator = Comparator.comparing(Restaurant::getAddress);
                break;
        }
        return restaurants.stream()
                .sorted(comparator)
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public Restaurant findById(String restaurantId) {
       return restaurantRepository.findByRestaurantId(restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }
}
