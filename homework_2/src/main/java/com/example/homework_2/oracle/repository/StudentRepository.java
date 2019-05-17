package com.example.homework_2.oracle.repository;

import com.example.homework_2.oracle.entity.BStudent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<BStudent,Integer> {

    BStudent findById(String id);
    List<BStudent> findAll();
}
