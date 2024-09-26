package com.backend.backend.Service;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.DishId;
import com.backend.backend.Entity.Recipe;
import com.backend.backend.Repository.RecipeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepo recipeRepo;
    public List<Recipe> getRecipesForDish(String dname, String email){
        DishId targetDid = new DishId(email, dname);
        return recipeRepo.findRecipeByDid(targetDid);
    }
}
