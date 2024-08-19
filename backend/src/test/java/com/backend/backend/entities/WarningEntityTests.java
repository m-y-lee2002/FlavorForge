package com.backend.backend.entities;

import com.backend.backend.Entity.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class WarningEntityTests {

    private static LocalUser testUser;
    private static Dish testDish;

    @BeforeAll
    static void setTestDummies() {
        testUser = createTestUser();
        testDish = createTestDish();
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
    public void testWarningPersistence(){
        entityManager.persist(testUser);
        entityManager.persist(testDish);
        entityManager.flush();
        WarningId warningId = new WarningId();
        warningId.setDid(testDish.getDid());
        warningId.setMessage("Hello World!");

        // Create the Warning entity and set the composite key
        Warning warning = new Warning();
        warning.setId(warningId);

        // Persist the entity
        entityManager.persist(warning);
        entityManager.flush();

        // Retrieve the persisted entity
        Warning result = entityManager.find(Warning.class, warning.getId());

        // Assertions to verify the persistence
        assertNotNull(result, "The persisted warning should not be null");
        assertEquals(warning.getId().getDid(), result.getId().getDid(), "The did should match");
        assertEquals(warning.getId().getMessage(), result.getId().getMessage(), "The message should match");
    }
}