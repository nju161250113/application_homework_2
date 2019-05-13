package com.example.homework_2.dao;

public interface CourseDao {

    //获得所有课程，返回xml字符串
    public String getAllCourse();

    //选课
    public boolean selectCourse(String userId,String courseId);

    //退课
    public boolean returnCourse(String userId,String courseId);

    //得到所有的选课关系
    public String getAllSelect();
}
