package com.example.homework_2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {
    @RequestMapping("/getMyClass/{userId}")
    public String getMyClass(@PathVariable("userId")String userId){
        return "";
    }
    @RequestMapping("/getOtherClass/{userId}")
    public String getOtherClass(@PathVariable("userId")String userId){
        return "";
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
    public String getAllClass(){
        return "";
    }
    @RequestMapping("/getAllSelect")
    public String getAllSelect(){
        return "";
    }
}
