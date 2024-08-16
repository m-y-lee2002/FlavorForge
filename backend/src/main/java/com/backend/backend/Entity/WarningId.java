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
public class WarningId implements Serializable {

    private DishId did;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarningId warningId = (WarningId) o;
        return Objects.equals(did, warningId.did) && Objects.equals(message, warningId.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, message);
    }
}