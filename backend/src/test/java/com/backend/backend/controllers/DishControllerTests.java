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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
        testDish = new Dish(testUser.getEmail(), "ramen", "my_penis_you_suck_all_the_time.png", "l", 10, 300, 5, 30, 3);
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
    public void testCreateDishFail() throws Exception{
        when(dishServices.checkForDish(testDish)).thenReturn(true);
        when(dishServices.saveDish(testDish)).thenReturn(testDish);
        String testDishJson = objectMapper.writeValueAsString(testDish);
        mockMvc.perform(post("/api/dish/createDish")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(testDishJson))
                .andExpect(status().isConflict());
    }
}
