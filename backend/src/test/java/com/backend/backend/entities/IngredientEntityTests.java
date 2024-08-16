package com.backend.backend.entities;

import com.backend.backend.Entity.Ingredient;
import com.backend.backend.Entity.LocalUser;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class IngredientEntityTests {
    @Autowired
    private TestEntityManager entityManager;
    private static Ingredient testIngredient;
    @BeforeAll
    public static void setTestDummies(){
        testIngredient = new Ingredient("Chicken", 300, 50, 20,5);
    }

    @Test
    @DirtiesContext
    public void testIngredientPersistence(){

        entityManager.persist(testIngredient);
        entityManager.flush();
        Ingredient result = entityManager.find(Ingredient.class, testIngredient.getIngredient_name());

        assertNotNull(result);
        assertEquals(result.getCalories(), 300, "Calories attribute does not match");
        assertEquals(result.getProtein(), 50, "Protein attribute does not match");
        assertEquals(result.getFibers(), 5, "Fiber attribute does not match");
        assertEquals(result.getIngredient_name(), "chicken", "name attribute does not match; potential casing issue.");
    }

}
