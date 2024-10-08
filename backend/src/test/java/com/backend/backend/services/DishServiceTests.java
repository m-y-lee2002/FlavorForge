package com.backend.backend.services;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Repository.DishRepo;
import com.backend.backend.Repository.LocalUserRepo;
import com.backend.backend.Service.DishServices;
import com.backend.backend.Service.LocalUserManagementService;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class DishServiceTests {
    @InjectMocks
    private DishServices dishServices;

    @Mock
    private DishRepo dishRepo;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    private static LocalUser testUser;
    private static Dish testDish;
    @BeforeAll
    public static void setTestDummies() {
        testUser = new LocalUser("testEmail@gmail.com", "testUser1", "1234");
        testDish = new Dish(testUser.getEmail(), "ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
    }

    @Test
    public void testCheckForDish_Success(){

        when(dishRepo.findDishByDid(testDish.getDid())).thenReturn(null);

        boolean result = dishServices.checkForDish(testDish);

        assertFalse(result);
    }
    @Test
    public void testCheckForDish_Fail(){
        when(dishRepo.findDishByDid(testDish.getDid())).thenReturn(testDish);

        boolean result = dishServices.checkForDish(testDish);

        assertTrue(result);
    }
    @Test
    public void testSaveDish_Success(){
        when(dishRepo.save(testDish)).thenReturn(testDish);

        Dish result = dishServices.saveDish(testDish);

       assertEquals(testDish, result);
    }
    @Test
    public void testGetFoodTypeDishes(){
        Dish testDish2 = new Dish(testUser.getEmail(), "Spagetti and Meatballs", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        Dish testDish3 = new Dish(testUser.getEmail(), "Cheese Burger", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
        List<Dish> list_of_dishes = new ArrayList<>();
        list_of_dishes.add(testDish);
        list_of_dishes.add(testDish2);
        list_of_dishes.add(testDish3);
        when(dishRepo.findDishByFoodTypeAndDidEmail("DINNER", testUser.getEmail())).thenReturn(list_of_dishes);

        List<Dish> result = dishServices.getFoodTypeDishes("DINNER", testUser.getEmail());
        assertEquals(result.size(),3);
    }
    @Test
    public void testGetDishByDid_Success(){
        when(dishRepo.findDishByDid(testDish.getDid())).thenReturn(testDish);
        Dish result = dishServices.getDishByDid(testDish.getDid());
        assertEquals(result, testDish);

    }
    @Test
    public void testGetDishByDid_Fail(){
        when(dishRepo.findDishByDid(testDish.getDid())).thenReturn(null);
        Dish result = dishServices.getDishByDid(testDish.getDid());
        assertNull(result);
    }
}
