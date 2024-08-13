package com.backend.backend.entities;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.LocalUser;
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
public class DishEntityTests {
    @Autowired
    private TestEntityManager entityManager;


    @Test
    @DirtiesContext
    public void testIngredientPersistence(){
        LocalUser sharon = new LocalUser("kimkatStufz@gmail.com", "sholiloli", "013845");
        Dish lunch_dish = new Dish(sharon.getEmail(),"ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);

        LocalUser user2 = new LocalUser("user2@gmail.com", "user2", "013845");
        Dish breakfast_dish = new Dish(user2.getEmail(),"pancake", "my_penis_you_suck_all_the_time.png", "b", 10, 300, 5, 30, 3);

        LocalUser user3 = new LocalUser("user3@gmail.com", "user3", "013845");
        Dish dinner_dish = new Dish(user3.getEmail(),"Steak", "my_penis_you_suck_all_the_time.png", "d1", 10, 300, 5, 30, 3);

        LocalUser user4 = new LocalUser("user4@gmail.com", "user4", "013845");
        Dish dessert_dish = new Dish(user4.getEmail(),"apple pie", "my_penis_you_suck_all_the_time.png", "d2", 10, 300, 5, 30, 3);

        LocalUser user5 = new LocalUser("user5@gmail.com", "user5", "013845");
        Dish drinks = new Dish(user5.getEmail(),"matcha latte", "my_penis_you_suck_all_the_time.png", "d3", 10, 300, 5, 30, 3);


        entityManager.persist(lunch_dish);
        entityManager.persist(breakfast_dish);
        entityManager.persist(dinner_dish);
        entityManager.persist(dessert_dish);
        entityManager.persist(drinks);
        entityManager.flush();


        Dish result = entityManager.find(Dish.class, lunch_dish.getDid());
        Dish result2 = entityManager.find(Dish.class, breakfast_dish.getDid());
        Dish result3 = entityManager.find(Dish.class, dinner_dish.getDid());
        Dish result4 = entityManager.find(Dish.class, dessert_dish.getDid());
        Dish result5 = entityManager.find(Dish.class, drinks.getDid());

        assertNotNull(result, "Lunch dish was not retrieved.");
        assertNotNull(result2, "Breakfast dish was not retrieved.");
        assertNotNull(result3, "Dinner dish was not retrieved.");
        assertNotNull(result4, "Dessert dish was not retrieved.");
        assertNotNull(result5, "Drinks dish was not retrieved.");

        assertEquals(lunch_dish.getFoodType(),"LUNCH","The dish does not recognize it is lunch dish.");
        assertEquals(result.getFoodType(), "LUNCH", "Resulting food type is not lunch");

        assertEquals(breakfast_dish.getFoodType(),"BREAKFAST","The dish does not recognize it is breakfast dish.");
        assertEquals(result2.getFoodType(), "BREAKFAST", "Resulting food type is not breakfast");

        assertEquals(dinner_dish.getFoodType(),"DINNER","The dish does not recognize it is dinner dish.");
        assertEquals(result3.getFoodType(), "DINNER", "Resulting food type is not dinner");

        assertEquals(dessert_dish.getFoodType(),"DESSERT","The dish does not recognize it is dessert dish.");
        assertEquals(result4.getFoodType(), "DESSERT", "Resulting food type is not dessert");

        assertEquals(drinks.getFoodType(),"DRINKS","The dish does not recognize it is drinks dish.");
        assertEquals(result5.getFoodType(), "DRINKS", "Resulting food type is not drinks");
    }
    @Test
    @DirtiesContext
    public void testSameUserWithMultipleDishes(){

    }
}
