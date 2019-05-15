package com.example.homework_2.service;

import com.example.homework_2.model.Course;
import com.example.homework_2.model.Student;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean login(String userId, String password) {
        ArrayList<Student>list=new ArrayList<>();
        boolean result=false;
        return false;
    }

    @Override
    public boolean addStudent(String userId, String name,String courseId) {

        return false;
    }

    @Override
    public ArrayList<Student> getAll() {
        return null;
    }
    public static boolean isValidate(ArrayList<Student>list,String userId,String password){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUserId().equals(userId)&&list.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public static String getAcademyOfCourse(String courseId){
        String result="";
        ArrayList<Course>list=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(courseId)){
                result=result+"A_";
            }
        }
        return result.equals("")?result:result.substring(0,result.length()-1);
    }


}
