package com.backend.backend.Repository;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.DishId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepo extends JpaRepository<Dish, Long> {
    Dish findDishByDid(DishId did);
}
