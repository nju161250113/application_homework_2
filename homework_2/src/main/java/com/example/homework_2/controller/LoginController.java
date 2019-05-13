package com.example.homework_2.controller;

import com.example.homework_2.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/student")
public class LoginController {

    @RequestMapping("/login/{userId}/{password}")
    public boolean login(@PathVariable("userId")String userId,@PathVariable("password")String password){
        return false;
    }
    @RequestMapping("/getAll")
    public ArrayList<Student> getAllStudent(){
        return null;
    }

}
