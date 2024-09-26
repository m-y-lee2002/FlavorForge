package com.backend.backend.Service;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.DishId;
import com.backend.backend.Repository.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return true;
        }else{
            return false;
        }
    }
    public List<Dish> getFoodTypeDishes(String foodType, String email){
        List<Dish> result = dishRepo.findDishByFoodTypeAndDidEmail(foodType, email);
        return result;
    }
    public Dish getDishByDid(DishId did){
        Dish result = dishRepo.findDishByDid(did);
        return result;
    }
}