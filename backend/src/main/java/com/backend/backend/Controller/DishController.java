package com.backend.backend.Controller;

import com.backend.backend.Entity.Dish;
import com.backend.backend.Service.DishServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")

public class DishController {
    @Autowired
    private DishServices dishServices;

    @PostMapping("/api/dish/createDish")
    public ResponseEntity<Dish> createDish(@RequestBody Dish dish){
        try{
            boolean dishExists = dishServices.checkForDish(dish);
            if(dishExists){
                return null;
            }else{
                Dish savedDish = dishServices.saveDish(dish);
                return ResponseEntity.ok(savedDish);
            }

        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
