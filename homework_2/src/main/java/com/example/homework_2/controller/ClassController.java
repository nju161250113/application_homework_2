package com.example.homework_2.controller;

import com.example.homework_2.model.Course;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/class")
public class ClassController {
    @RequestMapping("/getMyClass/{userId}")
    public ArrayList<Course> getMyClass(@PathVariable("userId")String userId){
        return null;
    }
    @RequestMapping("/getOtherClass/{userId}")
    public String getOtherClass(@PathVariable("userId")String userId){
        return null;
    }
    @RequestMapping("/selectClass/{userId}/{courseId}")
    public boolean addClass(@PathVariable("userId")String userId,@PathVariable("courseId")String courseId){
        return false;
    }
    @RequestMapping("/returnClass/{userId}/{courseId}")
    public boolean returnClass(@PathVariable("userId")String userId,@PathVariable("courseId")String courseId){
        return false;
    }
    @RequestMapping("/getAll")
    public ArrayList<Course> getAllClass(){
        return null;
    }
    @RequestMapping("/getAllSelect")
    public String getAllSelect(){
        return "";
    }
}
