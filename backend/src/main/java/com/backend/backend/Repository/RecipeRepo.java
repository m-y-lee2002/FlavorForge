package com.backend.backend.Repository;

import com.backend.backend.Entity.DishId;
import com.backend.backend.Entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepo extends JpaRepository<Recipe, String> {
    List<Recipe> findRecipesByDid(DishId did);
}
