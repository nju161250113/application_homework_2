package com.example.homework_2.oracle.repository;

import com.example.homework_2.oracle.entity.BCourse;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<BCourse,Integer> {
    BCourse findById(String id);
    List<BCourse> findAll();
}
