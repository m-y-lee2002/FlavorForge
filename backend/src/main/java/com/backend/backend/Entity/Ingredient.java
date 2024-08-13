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
@AllArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredient_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "calories")
    private Integer calories;

    @Column(name = "protein")
    private Integer protein;

    @Column(name = "carbs")
    private Integer carbs;

    @Column(name = "fibers")
    private Integer fibers;
    public Ingredient(String name, Integer calories, Integer protein, Integer carbs, Integer fibers ){
        this.name = name.toLowerCase();
        this.calories = calories;
        this.protein = protein;
        this.carbs = carbs;
        this.fibers = fibers;
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }
}
