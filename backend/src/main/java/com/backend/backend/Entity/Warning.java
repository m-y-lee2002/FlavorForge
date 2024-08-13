package com.backend.backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Warning")
public class Warning {

    @Id
    @Column(name="did")
    private Integer did;

    @Column(name="message")
    private String message;
}
