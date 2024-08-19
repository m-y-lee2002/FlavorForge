package com.backend.backend.Entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class RecipeId implements Serializable {
    private DishId did;
    private String ingredient_name;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeId recipeId = (RecipeId) o;
        return Objects.equals(did, recipeId.did) && Objects.equals(ingredient_name, recipeId.ingredient_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, ingredient_name);
    }
}