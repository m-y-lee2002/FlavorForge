package com.backend.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Recipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @EmbeddedId
    private RecipeId recipeId;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="measurement",nullable = false)
    private String measurement;

}
