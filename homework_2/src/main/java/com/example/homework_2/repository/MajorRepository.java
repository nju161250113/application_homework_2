package com.example.homework_2.repository;

import com.example.homework_2.entity.Major;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MajorRepository extends CrudRepository<Major,Integer> {
    Major findById(int id);
    List<Major> findAll();
}
