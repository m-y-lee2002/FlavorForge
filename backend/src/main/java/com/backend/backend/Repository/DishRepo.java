package com.backend.backend.Repository;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.DishId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepo extends JpaRepository<Dish, DishId> {
    Dish findDishByDid(DishId did);
    List<Dish> findDishByFoodTypeAndDidEmail(String foodType, String email);
} 