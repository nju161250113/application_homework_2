package com.example.homework_2.oracle.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
public class BChooseCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private BStudent student;
    @ManyToOne
    private BCourse course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
