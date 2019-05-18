package com.example.homework_2.service;

import com.example.homework_2.dao.CourseDao;
import com.example.homework_2.dao.StudentDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.Student;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class StudentServiceImpl implements StudentService {
    public static String A="A";
    public static String B="B";
    public static String C="C";
    @Autowired
    CourseService cs;
    @Autowired
    @Qualifier("courseDaoMySQLImpl")
    CourseDao ACd;
    @Autowired
    @Qualifier("courseDaoOracleImpl")
    CourseDao BCd;
    @Autowired
    @Qualifier("courseDaoSqlServerImpl")
    CourseDao CCd;
    @Autowired
    @Qualifier("studentDaoMySQLImpl")
    StudentDao Acd;
    @Autowired
    @Qualifier("studentDaoOracleImpl")
    StudentDao Bcd;
    @Autowired
    @Qualifier("studentDaoSqlServerImpl")
    StudentDao Ccd;
    @Override
    public boolean login(String userId, String password) {
        ArrayList<Student>list=new ArrayList<>();
        if(userId.startsWith(A)){
            list= (ArrayList<Student>) XmlUtils.xmlToList(Student.class,Acd.getAllStudent());
        }
        else if(userId.startsWith((B))){
            list= (ArrayList<Student>) XmlUtils.xmlToList(Student.class,Bcd.getAllStudent());
        }
        else if(userId.startsWith(C)){
            list= (ArrayList<Student>) XmlUtils.xmlToList(Student.class,Ccd.getAllStudent());
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
    public boolean addStudent(String userId,String courseId) {
        String academyInfo=getAcademyOfCourse(courseId);
        String[] academy=academyInfo.split("_");
        ArrayList<Student>students=getAll();
        String name="";
        for(int i=0;i<students.size();i++){
            if(students.get(i).getUserId().equals(userId)){
                name=students.get(i).getName();
            }
        }
        for(int i=0;i<academy.length;i++){
            if(academy[i].equals(A)){
                ArrayList<Student> list = (ArrayList<Student>) XmlUtils.xmlToList(Student.class, Acd.getAllStudent());
                boolean isIn=isIn(list,userId);
                if(!isIn){
                    Acd.addStudent(userId,name);
                }
            }
            if(academy[i].equals(B)){
                ArrayList<Student> list = (ArrayList<Student>) XmlUtils.xmlToList(Student.class, Bcd.getAllStudent());
                boolean isIn=isIn(list,userId);
                if(!isIn){
                    Bcd.addStudent(userId,name);
                }
            }
            if(academy[i].equals(C)){
                ArrayList<Student> list = (ArrayList<Student>) XmlUtils.xmlToList(Student.class, Ccd.getAllStudent());
                boolean isIn=isIn(list,userId);
                if(!isIn){
                    Ccd.addStudent(userId,name);
                }
            }
        }
        return true;
    }
    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student>result=new ArrayList<>();
        ArrayList<Student>listA=(ArrayList<Student>) XmlUtils.xmlToList(Student.class,Acd.getAllStudent());
        ArrayList<Student>listB=(ArrayList<Student>) XmlUtils.xmlToList(Student.class,Bcd.getAllStudent());
        ArrayList<Student>listC=(ArrayList<Student>) XmlUtils.xmlToList(Student.class,Ccd.getAllStudent());;
        add(result,listA);
        add(result,listB);
        add(result,listC);
        return result;
    }
    public boolean isValidate(ArrayList<Student>list,String userId,String password){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getUserId().equals(userId)&&list.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public String getAcademyOfCourse(String courseId){
        String result="";
        ArrayList<Course>listA= (ArrayList<Course>) XmlUtils.xmlToList(Course.class,ACd.getAllCourse());
        ArrayList<Course>listB= (ArrayList<Course>) XmlUtils.xmlToList(Course.class,BCd.getAllCourse());
        ArrayList<Course>listC= (ArrayList<Course>) XmlUtils.xmlToList(Course.class,CCd.getAllCourse());
        for(int i=0;i<listA.size();i++){
            if(listA.get(i).getCourseId().equals(courseId)){
                result=result+"A_";
            }
        }
        for(int i=0;i<listB.size();i++){
            if(listB.get(i).getCourseId().equals(courseId)){
                result=result+"B_";
            }
        }
        for(int i=0;i<listC.size();i++){
            if(listC.get(i).getCourseId().equals(courseId)){
                result=result+"C_";
            }
        }
        return result.equals("")?result:result.substring(0,result.length()-1);
    }
    public void add(ArrayList<Student>result,ArrayList<Student>list){
        for(int i=0;i<list.size();i++){
            Student st=list.get(i);
            boolean isIn=false;
            for(int j=0;j<result.size();j++){
                if(result.get(j).getUserId().equals(st.getUserId())){
                    isIn=true;
                }
            }
            if(!isIn){
                result.add(st);
            }
        }
    }
    public boolean isIn(ArrayList<Student>list,String userId){
        boolean isIn=false;
        for(int j=0;j<list.size();j++){
            if(list.get(j).getUserId().equals(userId)){
                isIn=true;;
            }
        }
        return isIn;
    }

}
