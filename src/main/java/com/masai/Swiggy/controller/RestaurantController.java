package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Restaurant;
import com.masai.Swiggy.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/getAll")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("get/{id}")
    public Restaurant getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }
}
