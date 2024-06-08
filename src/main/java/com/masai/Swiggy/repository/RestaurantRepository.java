package com.masai.Swiggy.repository;

import com.masai.Swiggy.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String> {
    Restaurant findByRestaurantId(String restaurantId);
}
