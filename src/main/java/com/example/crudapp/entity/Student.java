package com.example.crudapp.entity;


import com.sun.javafx.geom.transform.Identity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "crud")
@Data
public class Student {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Name")
    String Name;
    @Column(name = "Age")
    int  Age;
    @Column(name = "Year")
    String Year;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
