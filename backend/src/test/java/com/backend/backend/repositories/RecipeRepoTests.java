package com.backend.backend.repositories;

import com.backend.backend.Entity.*;
import com.backend.backend.Repository.DishRepo;
import com.backend.backend.Repository.RecipeRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class RecipeRepoTests {
    @Autowired
    private RecipeRepo recipeRepo;
    private static LocalUser testUser;
    private static Ingredient testIngredient;
    private static Dish testDish;
    private static Recipe testRecipe;

    @BeforeAll
    static void setTestDummies() {
        testUser = createTestUser();
        testIngredient = createTestIngredient();
        testDish = createTestDish();
        testRecipe = createTestRecipe();
    }
    private static Recipe createTestRecipe(){
        return new Recipe(testIngredient.getIngredient_name(),testDish.getDid(), 3.5, "grams");
    }
    private static Ingredient createTestIngredient() {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Chicken");
        ingredient.setCalories(300);
        ingredient.setProtein(50);
        ingredient.setCarbs(20);
        ingredient.setFibers(5);
        return ingredient;
    }
    private static Dish createTestDish(){
        DishId dishId = new DishId(testUser.getEmail(), "Steak");
        Dish dish = new Dish();
        dish.setDid(dishId);
        dish.setImg("steak_dinner.png");
        dish.setFoodType("d1");
        dish.setTotalTime(10);
        dish.setCalories(300);
        dish.setProtein(5);
        dish.setCarbs(30);
        dish.setFibers(3);
        return dish;
    }
    private static LocalUser createTestUser() {
        LocalUser localUser = new LocalUser();
        localUser.setEmail("testEmail@gmail.com");
        localUser.setUsername("test1");
        localUser.setPassword("12345");
        return localUser;
    }
    @Test
    @DirtiesContext
    public void testFindRecipesByDid(){
        recipeRepo.save(testRecipe);
        testRecipe.setIngredient_name("Sugar");
        recipeRepo.save(testRecipe);
        List<Recipe> result = recipeRepo.findRecipeByDid(testRecipe.getDid());

        assertEquals(result.size(), 2);
    }

}
