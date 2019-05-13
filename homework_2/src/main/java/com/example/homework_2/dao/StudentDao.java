package com.example.homework_2.dao;

public interface StudentDao {

    //获得所有的学生,返回值为xml字符串
    public String getAllStudent();

    //如果A学生选了B院系的课，那么B院系的数据库也要添加A学生信息
    public boolean addStudent(String userId,String name);

}
