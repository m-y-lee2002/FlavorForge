package com.backend.backend.services;

import com.backend.backend.Entity.Recipe;
import com.backend.backend.Repository.DishRepo;
import com.backend.backend.Repository.RecipeRepo;
import com.backend.backend.Service.DishServices;
import com.backend.backend.Service.RecipeService;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class RecipeServiceTests {
    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepo recipeRepo;
}
