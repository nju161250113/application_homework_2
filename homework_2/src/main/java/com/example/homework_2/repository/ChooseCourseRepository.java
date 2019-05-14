package com.example.homework_2.repository;

import com.example.homework_2.entity.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChooseCourseRepository extends CrudRepository<ChooseCourse,Integer> {
    ChooseCourse findById(int id);
    //找出所有选课记录
    List<ChooseCourse> findAll();
    //找出某课程的所有选课记录
    List<ChooseCourse> findAllByCourse(Course course);
    //找出某学生的所有选课记录
    List<ChooseCourse> findAllByStudent(Student student);
    List<ChooseCourse> findByStudentAndCourse(Student student, Course course);
    @Modifying
    @Transactional
    void deleteByStudentAndCourse(Student student, Course course);
}
