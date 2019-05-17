package com.example.homework_2.oracle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BCourse implements Serializable {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @OneToMany(mappedBy = "course")
    List<BChooseCourse> chooseCourses;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
