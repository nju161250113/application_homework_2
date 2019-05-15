package com.example.homework_2.service;

import com.example.homework_2.model.Course;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    @Override
    public boolean selectCourse(String courseId, String userId) {
        return false;
    }

    @Override
    public boolean cancelCourse(String courseId, String userId) {
        return false;
    }

    @Override
    public ArrayList<Course> getMyCourse(String userId) {
        ArrayList<Course>list=getAll();
        ArrayList<Course>result=new ArrayList<>();
        return null;
    }

    @Override
    public ArrayList<Course> getOtherCourse(String userId) {
        ArrayList<Course>list=getAll();
        ArrayList<Course>result=new ArrayList<>();
        return null;
    }

    @Override
    public ArrayList<Course> getAll() {
        return null;
    }
}
