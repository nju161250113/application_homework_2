package com.example.homework_2.service;

import com.example.homework_2.dao.CourseDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.DetailStuCourse;
import com.example.homework_2.model.StuCourse;
import com.example.homework_2.model.Student;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CourseServiceImpl implements CourseService {
    public static String A="A";
    public static String B="B";
    public static String C="C";
    @Autowired
    StudentService ss;

    @Autowired
    @Qualifier("courseDaoMySQLImpl")
    CourseDao Acd;
    @Autowired
    @Qualifier("courseDaoOracleImpl")
    CourseDao Bcd;
    @Autowired
    @Qualifier("courseDaoSqlServerImpl")
    CourseDao Ccd;
    @Override
    public boolean selectCourse(String courseId, String userId) {
        String academyInfo=getAcademyOfCourse(courseId);
        String[] academy=academyInfo.split("_");
        for(int i=0;i<academy.length;i++){
            if(academy[i].equals(A)){
                Acd.selectCourse(userId,courseId);
            }
            if(academy[i].equals(B)){
                Bcd.selectCourse(userId,courseId);
            }
            if(academy[i].equals(C)){
                Ccd.selectCourse(userId,courseId);
            }
        }
        return true;
    }

    @Override
    public boolean cancelCourse(String courseId, String userId) {
        String academyInfo=getAcademyOfCourse(courseId);
        String[] academy=academyInfo.split("_");
        for(int i=0;i<academy.length;i++){
            if(academy[i].equals(A)){
                Acd.returnCourse(userId,courseId);
            }
            if(academy[i].equals(B)){
                Bcd.returnCourse(userId,courseId);
            }
            if(academy[i].equals(C)){
                Ccd.returnCourse(userId,courseId);
            }
        }
        return true;
    }

    @Override
    public ArrayList<Course> getMyCourse(String userId) {
        ArrayList<Course>list=getAll();
        ArrayList<Course>result=new ArrayList<>();
        ArrayList<DetailStuCourse> sToc=getAllSelect();
        for(int i=0;i<sToc.size();i++){
            if(sToc.get(i).getStuId().equals(userId)){
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
        ArrayList<Course>result=new ArrayList<>();
        ArrayList<Course>courseA= (ArrayList<Course>) XmlUtils.xmlToList(Course.class,Acd.getAllCourse());
        ArrayList<Course>courseB=new ArrayList<>();
        ArrayList<Course>courseC=new ArrayList<>();
        add(result,courseA);
        add(result,courseB);
        add(result,courseC);
        return result;
    }

    @Override
    public ArrayList<DetailStuCourse> getAllSelect() {
        ArrayList<StuCourse>listA= (ArrayList<StuCourse>) XmlUtils.xmlToList(StuCourse.class,Acd.getAllSelect());
        ArrayList<StuCourse>listB= (ArrayList<StuCourse>) XmlUtils.xmlToList(StuCourse.class,Bcd.getAllSelect());
        ArrayList<StuCourse>listC= (ArrayList<StuCourse>) XmlUtils.xmlToList(StuCourse.class,Ccd.getAllSelect());
        ArrayList<DetailStuCourse>result=new ArrayList<>();
        addDetail(result,listA);
        addDetail(result,listB);
        addDetail(result,listC);
        return result;
    }
    public  Course getCourse(String courseId,ArrayList<Course> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(courseId)){
                return list.get(i);
            }
        }
        return null;
    }
    public  String findStuName(ArrayList<Student>list, String id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUserId().equals(id)){
                return list.get(i).getName();
            }
        }
        return "";
    }
    public  String findCourseName(ArrayList<Course>list, String id){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(id)){
                return list.get(i).getName();
            }
        }
        return "";
    }
    public  void add(ArrayList<Course>result,ArrayList<Course>list){
        for(int i=0;i<list.size();i++){
            Course c=list.get(i);
            if(!result.contains(c)){
                result.add(c);
            }
        }
    }
    public String getAcademyOfCourse(String courseId){
        String result="";
        ArrayList<Course>list=getAll();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(courseId)){
                result=result+"A_";
            }
        }
        return result.equals("")?result:result.substring(0,result.length()-1);
    }
    public  void addDetail(ArrayList<DetailStuCourse>result,ArrayList<StuCourse>list){
        ArrayList<Course>courses=getAll();
        ArrayList<Student>students=ss.getAll();
        for(int i=0;i<list.size();i++){
            StuCourse sc=list.get(i);
            DetailStuCourse dsc=new DetailStuCourse(sc.getStudentId(),findStuName(students,sc.getStudentId()),sc.getCourseId(),findCourseName(courses,sc.getCourseId()));
            if(!result.contains(dsc)){
                result.add(dsc);
            }
        }
    }
}
