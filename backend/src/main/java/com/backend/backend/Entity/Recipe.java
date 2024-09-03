package com.backend.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Recipe")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Recipe {
    @Id
    @Column(name="ingredient_name")
    private String ingredient_name;

    @Embedded
    @Column(name="did", nullable = false)
    private DishId did;

    @Column(name="amount",nullable = false)
    private double amount;

    @Column(name="measurement",nullable = false)
    private String measurement;

}