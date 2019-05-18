package com.example.homework_2.controller;

import com.example.homework_2.model.Student;
import com.example.homework_2.service.StudentService;
import com.example.homework_2.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class LoginController {
    @Autowired
    StudentService ss;

    @RequestMapping("/login/{userId}/{password}")
    public boolean login(@PathVariable("userId")String userId,@PathVariable("password")String password){
        return ss.login(userId,password);
    }
    @RequestMapping("/getAll")
    public ArrayList<Student> getAllStudent(){
        return ss.getAll();
    }

}
