package com.backend.backend.Service;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Repository.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishServices {
    @Autowired
    private DishRepo dishRepo;

    public Dish saveDish(Dish targetDish){
        try {
            return dishRepo.save(targetDish);
        } catch (Exception e) {
            // Handle other unexpected exceptions
            throw new RuntimeException("Failed to save dish: " + e.getMessage());
        }
    }
    public Boolean checkForDish(Dish targetDish){
        Dish result = dishRepo.findDishByDid(targetDish.getDid());
        if(result != null){
            return null;
        }else{
            return false;
        }
    }
}