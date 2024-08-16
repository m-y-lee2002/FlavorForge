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
public class DishId implements Serializable {

    private String email;
    private String dname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishId dishId = (DishId) o;
        return Objects.equals(email, dishId.email) && Objects.equals(dname, dishId.dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, dname);
    }

}