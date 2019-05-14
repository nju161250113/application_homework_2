package com.example.homework_2.repository;


import com.example.homework_2.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course,Integer> {
    Course findById(int id);
    List<Course> findAll();
}
