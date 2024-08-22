package com.backend.backend.Controller;

import com.backend.backend.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
}
