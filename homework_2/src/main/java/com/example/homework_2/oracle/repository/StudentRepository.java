package com.example.homework_2.oracle.repository;

import com.example.homework_2.oracle.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Integer> {

    Student findById(String id);
    List<Student> findAll();
}
