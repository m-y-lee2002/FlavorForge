package com.backend.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Ingredient")
@NoArgsConstructor
public class Ingredient {


    @Id
    @Column(name = "ingredient_name", nullable = false, unique = true)
    private String ingredient_name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "carbs")
    private Integer carbs;

    @Column(name = "fibers")
    private Integer fibers;
    public Ingredient(String name, Integer calories, Integer protein, Integer carbs, Integer fibers ){
        this.ingredient_name = name.toLowerCase();
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fibers = fibers;
    }

    public void setName(String name) {
        this.ingredient_name = name.toLowerCase();
    }
}
