package com.backend.backend.entities;

import com.backend.backend.Entity.Ingredient;
import com.backend.backend.Entity.LocalUser;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    @Test
    @DirtiesContext
    public void testIngredientPersistence(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Chicken");
        ingredient.setCalories(300);
        ingredient.setProtein(50);
        ingredient.setCarbs(20);
        ingredient.setFibers(5);

        entityManager.persist(ingredient);
        entityManager.flush();
        Ingredient result = entityManager.find(Ingredient.class, ingredient.getId());

        assertNotNull(result);
        assertEquals(result.getCalories(), 300, "Calories attribute does not match");
        assertEquals(result.getProtein(), 50, "Protein attribute does not match");
        assertEquals(result.getFibers(), 5, "Fiber attribute does not match");
        assertEquals(result.getId(), 1, "id attribute does not match");
        assertEquals(result.getName(), "chicken", "name attribute does not match; potential casing issue.");
    }

    @Test
    @DirtiesContext
    public void testIdAutoIncrement(){
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Chicken");
        ingredient1.setCalories(300);
        ingredient1.setProtein(50);
        ingredient1.setCarbs(20);
        ingredient1.setFibers(5);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setName("Chicken");
        ingredient2.setCalories(300);
        ingredient2.setProtein(50);
        ingredient2.setCarbs(20);
        ingredient2.setFibers(5);

        entityManager.persist(ingredient1);
        entityManager.flush();
        entityManager.persist(ingredient2);
        Ingredient result = entityManager.find(Ingredient.class,ingredient1.getId());
        Ingredient result2 = entityManager.find(Ingredient.class,ingredient2.getId());

        assertEquals(result.getId(), 1, "ingredient1 id is not 1");
        assertEquals(result2.getId(), 2, "ingredient2 id is not 2");
    }

    @Test
    @DirtiesContext
    public void testAllArgumentConstructor(){
        Ingredient ingredient = new Ingredient("Chicken", 300, 50, 20, 5);

        entityManager.persist(ingredient);
        entityManager.flush();
        Ingredient result = entityManager.find(Ingredient.class, ingredient.getId());

        assertNotNull(result);
        assertEquals(result.getName(), "chicken");
    }
}
