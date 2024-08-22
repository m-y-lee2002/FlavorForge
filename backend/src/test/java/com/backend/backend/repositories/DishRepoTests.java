package com.backend.backend.repositories;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.DishRepo;
import com.backend.backend.Repository.LocalUserRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class DishRepoTests {
    @Autowired
    private DishRepo dishRepo;

    private static LocalUser testUser;
    private static Dish testDish;
    private static Dish testDish2;
    private static Dish testDish3;
    private static Dish testDish_differentFoodType;

    @BeforeAll
    public static void setTestDummies() {
        testUser = new LocalUser("testEmail@gmail.com", "testUser1", "1234");
        testDish = new Dish(testUser.getEmail(), "ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        testDish2 = new Dish(testUser.getEmail(), "Spagetti and Meatballs", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        testDish3 = new Dish(testUser.getEmail(), "Cheese Burger", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        testDish_differentFoodType = new Dish(testUser.getEmail(), "Fried Rice", "my_penis_you_suck_all_the_time.png", "d1", 10, 300, 5, 30, 3);
    }
    @Test
    @DirtiesContext
    public void testFindDishByDid(){
        dishRepo.save(testDish);
        Dish result = dishRepo.findDishByDid(testDish.getDid());
        assertEquals(result, testDish);
    }

    @Test
    @DirtiesContext
    public void testUpdateDishUsingSave(){
        dishRepo.save(testDish);
        Dish result = dishRepo.findDishByDid(testDish.getDid());
        assertEquals(result, testDish);

        result.changeFoodType("d1");

        dishRepo.save(result);
        Dish result2 = dishRepo.findDishByDid(testDish.getDid());
        assertEquals(result2, result);
        assertNotEquals(result2, testDish);

    }
    @Test
    @DirtiesContext
    public void testFindDishByFoodType_Success(){
        dishRepo.save(testDish);
        dishRepo.save(testDish2);
        dishRepo.save(testDish3);
        dishRepo.save(testDish_differentFoodType);

        List<Dish> result = dishRepo.findDishByFoodType("LUNCH");
        assertEquals(result.size(), 3);

        List<Dish> result2 = dishRepo.findDishByFoodType("DINNER");
        assertEquals(result2.size(), 1);

        List<Dish> result3 = dishRepo.findDishByFoodType("BREAKFAST");
        assertEquals(result3.size(), 0);

    }
}
