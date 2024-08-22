package com.backend.backend.controllers;

import com.backend.backend.Controller.DishController;
import com.backend.backend.Entity.Dish;
import com.backend.backend.Entity.LocalUser;
import com.backend.backend.Service.DishServices;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DishController.class)
public class DishControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DishServices dishServices;

    private static Dish testDish;
    private static LocalUser testUser;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeAll
    public static void setTestDummies() {
        testUser = new LocalUser("testEmail@gmail.com", "testUser1", "1234");
        testDish = new Dish(testUser.getEmail(), "ramen", "ramen_image.png", "DINNER", 10, 300, 5, 30, 3);
    }

    @Test
    public void testCreateDishSuccess() throws Exception {
        when(dishServices.checkForDish(testDish)).thenReturn(false);
        when(dishServices.saveDish(testDish)).thenReturn(testDish);
        String testDishJson = objectMapper.writeValueAsString(testDish);
        mockMvc.perform(post("/api/dish/createDish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testDishJson))
                .andExpect(status().isOk())
                .andExpect(content().json(testDishJson));
    }

    @Test
    public void testCreateDishFail() throws Exception {
        when(dishServices.checkForDish(testDish)).thenReturn(true);
        when(dishServices.saveDish(testDish)).thenReturn(testDish);
        String testDishJson = objectMapper.writeValueAsString(testDish);
        mockMvc.perform(post("/api/dish/createDish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testDishJson))
                .andExpect(status().isConflict());
    }

    @Test
    public void testFindAllFoodTypeDishes() throws Exception {
        Dish testDish2 = new Dish(testUser.getEmail(), "Spaghetti and Meatballs", "spaghetti_image.png", "DINNER", 10, 300, 5, 30, 3);
        Dish testDish3 = new Dish(testUser.getEmail(), "Cheeseburger", "cheeseburger_image.png", "DINNER", 10, 300, 5, 30, 3);
        List<Dish> listOfDishes = new ArrayList<>();
        listOfDishes.add(testDish);
        listOfDishes.add(testDish2);
        listOfDishes.add(testDish3);
        when(dishServices.getFoodTypeDishes("DINNER")).thenReturn(listOfDishes);

        mockMvc.perform(get("/api/dish/getFoodTypeDishes/{food_type}", "DINNER")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].did.email", is(testDish.getDid().getEmail())))
                .andExpect(jsonPath("$[0].did.dname", is(testDish.getDid().getDname())))
                .andExpect(jsonPath("$[1].did.email", is(testDish2.getDid().getEmail())))
                .andExpect(jsonPath("$[1].did.dname", is(testDish2.getDid().getDname())))
                .andExpect(jsonPath("$[2].did.email", is(testDish3.getDid().getEmail())))
                .andExpect(jsonPath("$[2].did.dname", is(testDish3.getDid().getDname())));
    }
}