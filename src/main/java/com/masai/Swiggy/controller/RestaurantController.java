package com.masai.Swiggy.controller;

import com.masai.Swiggy.entity.Restaurant;
import com.masai.Swiggy.service.RestaurantService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @GetMapping("/getAll")
    public List<Restaurant> getAllRestaurants(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "name") String sortBy) {
        logger.info("Fetching all restaurants based on parameters pageNo :{} pageSize: {} " +
                "and sortBy :{}",page,size,sortBy);
        return restaurantService.getAllRestaurants(page, size, sortBy);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@Valid @RequestBody Restaurant restaurant) {
        logger.info("Request received to add restaurant: {}",restaurant);
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("get/{id}")
    public Restaurant getRestaurantById(@PathVariable String id) {
        logger.info("Request received to get restaurant by restaurantId: {}",id);
        return restaurantService.getRestaurantById(id);
    }
}
