package com.example.homework_2.service;

import com.example.homework_2.model.Student;

import java.util.ArrayList;

public interface StudentService {
    public boolean login(String userId,String password);

    public boolean addStudent(String userId,String courseId);

    public ArrayList<Student> getAll();
}
