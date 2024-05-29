package com.example.nex.demo003.Domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Teacher {
    @Id
    private String id;
    private String name;
    private String address;

}
