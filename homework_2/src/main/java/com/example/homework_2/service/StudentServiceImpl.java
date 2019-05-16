package com.example.homework_2.service;

import com.example.homework_2.dao.CourseDao;
import com.example.homework_2.dao.StudentDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.Student;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
    public static String A="A";
    public static String B="B";
    public static String C="C";
    XmlUtils xu=new XmlUtils();
    @Autowired
    @Qualifier("studentDaoMySQLImpl")
    StudentDao Acd;
    @Override
    public boolean login(String userId, String password) {
        ArrayList<Student>list=new ArrayList<>();
        if(userId.startsWith(A)){
            list= (ArrayList<Student>) xu.xmlToList(Student.class,Acd.getAllStudent());
        }
        else if(userId.startsWith((B))){

        }
        else if(userId.startsWith(C)){

        }else{
            return false;
        }
        boolean result=false;
        for(int i=0;i<list.size();i++){
            Student st=list.get(i);
            if(st.getUserId().equals(userId)&&st.getPassword().equals(password)){
                result=true;
            }
        }
        return result;
    }

    @Override
    public boolean addStudent(String userId, String name,String courseId) {
        String academyInfo=getAcademyOfCourse(courseId);
        String[] academy=academyInfo.split("_");
        for(int i=0;i<academy.length;i++){
            if(academy[i].equals(A)){
                Acd.addStudent(userId,name);
            }
            if(academy[i].equals(B)){
                Acd.addStudent(userId,name);
            }
            if(academy[i].equals(C)){
                Acd.addStudent(userId,name);
            }
        }
        return true;
    }

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student>result=new ArrayList<>();
        ArrayList<Student>listA = (ArrayList<Student>) xu.xmlToList(Student.class,Acd.getAllStudent());
        ArrayList<Student>listB=new ArrayList<>();
        ArrayList<Student>listC=new ArrayList<>();
        add(result,listA);
        add(result,listB);
        add(result,listC);
        return result;
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
        CourseService cs=new CourseServiceImpl();
        ArrayList<Course>list=cs.getAll();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getCourseId().equals(courseId)){
                result=result+"A_";
            }
        }
        return result.equals("")?result:result.substring(0,result.length()-1);
    }
    public static void add(ArrayList<Student>result,ArrayList<Student>list){
        for(int i=0;i<list.size();i++){
            Student st=list.get(i);
            if(!result.contains(st)){
                result.add(st);
            }
        }
    }

}
