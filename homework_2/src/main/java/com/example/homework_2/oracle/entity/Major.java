package com.example.homework_2.oracle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Major implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "major")
    List<Student> studentList;
    private String name;
    @OneToMany(mappedBy = "major")
    List<Course> courses;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
