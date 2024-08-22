package com.backend.backend.controllers;

import com.backend.backend.Controller.DishController;
import com.backend.backend.Controller.RecipeController;
import com.backend.backend.Service.DishServices;
import com.backend.backend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RecipeController.class)
public class RecipeControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RecipeService recipeService;
}
