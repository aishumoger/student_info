package com.javaApi.javaApi.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "student")
@Getter
@Setter
public class Students {
        @Id
    private int rollno;

    private String name;
    private int age;
    private String city;
    private String grade;
    private int marks;
}
