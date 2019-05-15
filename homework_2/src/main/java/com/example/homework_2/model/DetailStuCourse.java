package com.example.homework_2.model;

public class DetailStuCourse {
    //这个是逻辑->前端用的 后端用StuCourse
    private String stuId;
    private String stuName;
    private String courseId;
    private String courseName;

    public DetailStuCourse(String stuId, String stuName, String courseId, String courseName) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
