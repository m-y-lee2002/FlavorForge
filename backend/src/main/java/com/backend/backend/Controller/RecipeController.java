package com.backend.backend.Controller;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.Recipe;
import com.backend.backend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

//    @GetMapping("/api/recipe/getRecipe/{dname}/{email}")
//    public ResponseEntity<List<Recipe>> findAllRecipe(@PathVariable("did") String food_type){
//        try{
//            List<Dish> target_dishes = dishServices.getFoodTypeDishes(food_type);
//            return ResponseEntity.ok(target_dishes);
//        }catch(RuntimeException e){
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
