package com.masai.Swiggy.mvcController;

import com.masai.Swiggy.entity.Restaurant;
import com.masai.Swiggy.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class RestaurantMvcController {

    @Autowired
    private RestaurantService restaurantService;

    private static final Logger logger = LoggerFactory.getLogger(RestaurantMvcController.class);

    @GetMapping("/getAll")
    public String getAllRestaurants(Model model) {
        logger.info("Fetching all restaurants");
        List<Restaurant> restaurants = restaurantService.getAll();
        model.addAttribute("restaurants", restaurants);
        return "restaurant-list";
    }

    @GetMapping("/show")
    public String showAddRestaurantForm(Model model) {
        logger.info("Showing add restaurant form");
        model.addAttribute("restaurant", new Restaurant());
        return "restaurant-form";
    }

    @PostMapping("/add")
    public String addRestaurant(@ModelAttribute("restaurant") @Validated Restaurant restaurant) {
        logger.info("Received request to add restaurant: {}", restaurant);
        restaurantService.addRestaurant(restaurant);
        return "redirect:/restaurants/getAll";
    }
}
