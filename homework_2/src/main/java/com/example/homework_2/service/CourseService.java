package com.example.homework_2.service;

import com.example.homework_2.model.Course;
import com.example.homework_2.model.DetailStuCourse;

import java.util.ArrayList;

public interface CourseService {
    public boolean selectCourse(String courseId,String userId);

    public boolean cancelCourse(String courseId,String userId);

    public ArrayList<Course> getMyCourse(String userId);

    public ArrayList<Course> getOtherCourse(String userId);

    public ArrayList<Course> getAll();

    public ArrayList<DetailStuCourse> getAllSelect();
}
