package com.example.homework_2.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("course")
public class Course {
    private String courseId;
    private String name;
    public Course(){

    }
    public Course(String courseId,String name){
        this.courseId=courseId;
        this.name=name;
    }
    public void setCourseId(String courseId){this.courseId=courseId;}
    public void setName(String name){this.name=name;}
    public String getCourseId(){return courseId;}
    public String getName(){return name;}
}
