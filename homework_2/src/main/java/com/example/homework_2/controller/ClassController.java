package com.example.homework_2.controller;

import com.example.homework_2.model.Course;
import com.example.homework_2.model.DetailStuCourse;
import com.example.homework_2.model.StuCourse;
import com.example.homework_2.service.CourseService;
import com.example.homework_2.service.CourseServiceImpl;
import com.example.homework_2.service.StudentService;
import com.example.homework_2.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    CourseService cs;
    @Autowired
    StudentService ss;
    @RequestMapping("/getMyClass/{userId}")
    public ArrayList<Course> getMyClass(@PathVariable("userId")String userId){
        return cs.getMyCourse(userId);
    }
    @RequestMapping("/getOtherClass/{userId}")
    public ArrayList<Course> getOtherClass(@PathVariable("userId")String userId){
        return cs.getOtherCourse(userId);
    }
    @RequestMapping("/selectClass/{userId}/{courseId}")
    public boolean addClass(@PathVariable("userId")String userId,@PathVariable("courseId")String courseId){
        ss.addStudent(userId,courseId);
        return cs.selectCourse(courseId,userId);
    }
    @RequestMapping("/returnClass/{userId}/{courseId}")
    public boolean returnClass(@PathVariable("userId")String userId,@PathVariable("courseId")String courseId){
        return cs.cancelCourse(courseId,userId);
    }
    @RequestMapping("/getAll")
    public ArrayList<Course> getAllClass(){
        return cs.getAll();
    }
    @RequestMapping("/getAllSelect")
    public ArrayList<DetailStuCourse> getAllSelect(){
        return cs.getAllSelect();
    }
}
