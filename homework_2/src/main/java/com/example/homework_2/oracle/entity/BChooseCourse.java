package com.example.homework_2.oracle.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BChooseCourse implements Serializable {
    @Id
    private String id;
    @ManyToOne
    private BStudent student;
    @ManyToOne
    private BCourse course;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BStudent getStudent() {
        return student;
    }

    public void setStudent(BStudent student) {
        this.student = student;
    }

    public BCourse getCourse() {
        return course;
    }

    public void setCourse(BCourse course) {
        this.course = course;
    }
}
