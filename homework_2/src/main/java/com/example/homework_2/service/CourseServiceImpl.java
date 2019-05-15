package com.example.homework_2.service;

import com.example.homework_2.model.Course;
import com.example.homework_2.model.DetailStuCourse;
import com.example.homework_2.model.StuCourse;

import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    @Override
    public boolean selectCourse(String courseId, String userId) {
        return false;
    }

    @Override
    public boolean cancelCourse(String courseId, String userId) {
        return false;
    }

    @Override
    public ArrayList<Course> getMyCourse(String userId) {
        ArrayList<Course>list=getAll();
        ArrayList<Course>result=new ArrayList<>();
        ArrayList<DetailStuCourse> sToc=getAllSelect();
        for(int i=0;i<sToc.size();i++){
            if(sToc.get(i).equals(userId)){
                result.add(getCourse(sToc.get(i).getCourseId(),list));
            }
        }
        return result;
    }

    @Override
    public ArrayList<Course> getOtherCourse(String userId) {
        ArrayList<Course>list=getAll();
        ArrayList<Course>result=new ArrayList<>();
        ArrayList<Course>my=getMyCourse(userId);
        for(int i=0;i<list.size();i++){
            Course c=list.get(i);
            if(!my.contains(c)){
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public ArrayList<Course> getAll() {
        return null;
    }

    @Override
    public ArrayList<DetailStuCourse> getAllSelect() {
        return null;
    }
    public static Course getCourse(String courseId,ArrayList<Course> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(courseId)){
                return list.get(i);
            }
        }
        return null;
    }
}
