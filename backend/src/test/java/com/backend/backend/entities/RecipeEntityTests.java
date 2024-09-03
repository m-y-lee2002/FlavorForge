package com.backend.backend.entities;

import com.backend.backend.Entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.cglib.core.Local;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class RecipeEntityTests {
    private static LocalUser testUser;
    private static Ingredient testIngredient;
    private static Dish testDish;

    @BeforeAll
    static void setTestDummies() {
        testUser = createTestUser();
        testIngredient = createTestIngredient();
        testDish = createTestDish();
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
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testRecipePersistence(){
        entityManager.persist(testUser);
        entityManager.persist(testIngredient);
        entityManager.persist(testDish);
        entityManager.flush();
        Recipe recipe = new Recipe(testIngredient.getIngredient_name(),testDish.getDid(), 3.5, "grams");

        entityManager.persist(recipe);
        entityManager.flush();
        Recipe result = entityManager.find(Recipe.class, recipe.getIngredient_name());

        assertNotNull(result, "Recipe could not be found using recipe's composite key recipeId.");

        assertEquals(result.getAmount(),3.5);
        assertEquals(result.getMeasurement(), "grams");
        assertEquals(result.getDid(), testDish.getDid(), "Resulting recipe's did does not match.");
        assertEquals(result.getIngredient_name(), testIngredient.getIngredient_name(), "Resulting recipe's ingredient name does not match.");

    }
}