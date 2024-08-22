package com.backend.backend.Repository;

import com.backend.backend.Entity.Recipe;
import com.backend.backend.Entity.RecipeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, RecipeId> {
}
