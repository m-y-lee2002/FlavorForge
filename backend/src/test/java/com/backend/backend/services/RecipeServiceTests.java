package com.backend.backend.services;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Entity.Recipe;
import com.backend.backend.Repository.DishRepo;
import com.backend.backend.Repository.RecipeRepo;
import com.backend.backend.Service.DishServices;
import com.backend.backend.Service.RecipeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecipeServiceTests {
    @InjectMocks
    private RecipeService recipeService;

    @Mock
    private RecipeRepo recipeRepo;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    private static LocalUser testUser;
    private static Dish testDish;
    private static Recipe recipe1;
    private static Recipe recipe2;
    private static Recipe recipe3;
    @BeforeAll
    public static void setTestDummies(){
        testUser = new LocalUser("testEmail@gmail.com", "testUser1", "1234");
        testDish = new Dish(testUser.getEmail(), "ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        recipe1 = new Recipe("Noodles", testDish.getDid(),1,"cups");
        recipe2 = new Recipe("Chicken Stock", testDish.getDid(),2,"cups");
        recipe3 = new Recipe("Beef", testDish.getDid(),100,"grams");
    }
    @Test
    public void testGetRecipesForDish(){
        List<Recipe> list_of_recipes = new ArrayList<>();
        list_of_recipes.add(recipe1);
        list_of_recipes.add(recipe2);
        list_of_recipes.add(recipe3);
        when(recipeRepo.findRecipeByDid(testDish.getDid())).thenReturn(list_of_recipes);
        List<Recipe> result = recipeRepo.findRecipeByDid(testDish.getDid());
        assertEquals(result.size(),3);
    }

}
