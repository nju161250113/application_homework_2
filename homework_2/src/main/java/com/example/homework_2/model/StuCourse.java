package com.example.homework_2.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("stuCourse")
public class StuCourse {
    private String studentId;
    private  String courseId;

    public StuCourse() {
    }

    public StuCourse(String studentId, String courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
