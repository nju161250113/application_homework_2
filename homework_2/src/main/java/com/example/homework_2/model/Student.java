package com.example.homework_2.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("student")
public class Student {
    private String userId;
    private String password;
    private String name;
    private String academy;
    public Student(){

    }
    public Student(String userId,String password,String name,String academy){
        this.userId=userId;
        this.password=password;
        this.name=name;
        this.academy=academy;

    }
    public void setUserId(String userId){this.userId=userId;}
    public void setPassword(String password){this.password=password;}
    public void setAcademy(String academy){this.academy=academy;}
    public void setName(String name){this.name=name;}
    public String getUserId(){return userId;}
    public String getPassword(){return password;}
    public String getAcademy(){return academy;}
    public String getName(){return name;}
}
