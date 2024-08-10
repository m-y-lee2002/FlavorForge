package com.backend.backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

}
