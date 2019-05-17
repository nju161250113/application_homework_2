package com.example.homework_2.oracle.repository;

import com.example.homework_2.oracle.entity.*;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ChooseCourseRepository extends CrudRepository<BChooseCourse,Integer> {
    BChooseCourse findById(int id);
    //找出所有选课记录
    List<BChooseCourse> findAll();
    //找出某课程的所有选课记录
    List<BChooseCourse> findAllByCourse(BCourse course);
    //找出某学生的所有选课记录
    List<BChooseCourse> findAllByStudent(BStudent student);
    List<BChooseCourse> findByStudentAndCourse(BStudent student, BCourse course);
    @Modifying
    @Transactional
    void deleteByStudentAndCourse(BStudent student, BCourse course);
}
