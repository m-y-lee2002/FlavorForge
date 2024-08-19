package com.backend.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Recipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Recipe {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private RecipeId recipeId;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="measurement",nullable = false)
    private String measurement;

}