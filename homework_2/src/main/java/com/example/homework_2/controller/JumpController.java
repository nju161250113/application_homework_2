package com.example.homework_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JumpController {
    @RequestMapping("/")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/coursepage")
    public String coursePage() {
        return "course-page";
    }

    @RequestMapping("/statisticpage")
    public String statisticPage() {
        return "statistic";
    }
}
