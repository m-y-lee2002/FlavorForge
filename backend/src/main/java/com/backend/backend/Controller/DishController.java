package com.backend.backend.Controller;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Service.DishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class DishController {
    @Autowired
    private DishServices dishServices;

    @PostMapping("/api/dish/createDish")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish) {
        try {
            boolean dishExists = dishServices.checkForDish(dish);
            if (dishExists) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Return CONFLICT status
            } else {
                Dish savedDish = dishServices.saveDish(dish);
                return ResponseEntity.ok(savedDish);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/api/dish/getFoodTypeDishes/{food_type}/{email}")
    public ResponseEntity<List<Dish>> findAllDishesOfFoodType(@PathVariable("food_type") String food_type, @PathVariable("email") String email){
        try{
            List<Dish> target_dishes = dishServices.getFoodTypeDishes(food_type,email);
            return ResponseEntity.ok(target_dishes);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}