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
        Dish dish = new Dish(sharon.getEmail(),"ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);

        //Be able to insert new dish into table
        entityManager.persist(dish);
        entityManager.flush();

        //Be able to find that same dish given sharon's email
        Dish result = entityManager.find(Dish.class, dish.getDid());

        //Check to see if we are able to get the dish back
        assertNotNull(result);

        //convert letter l or L to the word "LUNCH"
        assertEquals(dish.getFoodType(),"LUNCH","The dish should turn the food type to capital letter L for uniformity");
        assertEquals(result.getFoodType(), "LUNCH");


    }
}
