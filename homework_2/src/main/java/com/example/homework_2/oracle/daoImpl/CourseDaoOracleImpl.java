package com.example.homework_2.oracle.daoImpl;

import com.example.homework_2.dao.CourseDao;
import com.example.homework_2.dao.StudentDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.StuCourse;
import com.example.homework_2.oracle.entity.BChooseCourse;
import com.example.homework_2.oracle.entity.BCourse;
import com.example.homework_2.oracle.repository.ChooseCourseRepository;
import com.example.homework_2.oracle.repository.CourseRepository;
import com.example.homework_2.oracle.repository.StudentRepository;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("courseDaoOracleImpl")
@Qualifier("courseDaoOracleImpl")
public class CourseDaoOracleImpl implements CourseDao {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ChooseCourseRepository chooseCourseRepository;
    @Override
    public String getAllCourse() {
        List<Course> list=new ArrayList<>();
        List<BCourse> bCourseList = courseRepository.findAll();
        for (int i=0;i<bCourseList.size();i++){
            Course course = new Course(bCourseList.get(i).getId(),bCourseList.get(i).getName());
            list.add(course);
        }
        return XmlUtils.toXml(list);
    }

    @Override
    public boolean selectCourse(String userId, String courseId) {
        BChooseCourse bChooseCourse = new BChooseCourse();
        bChooseCourse.setId(createOrdercheckId());
        bChooseCourse.setStudent(studentRepository.findById(userId));
        bChooseCourse.setCourse(courseRepository.findById(courseId));
        chooseCourseRepository.save(bChooseCourse);
        List<BChooseCourse> chooseCourses = chooseCourseRepository.findByStudentAndCourse(studentRepository.findById(userId),courseRepository.findById(courseId));
        return chooseCourses.size()!=0;
    }

    @Override
    public boolean returnCourse(String userId, String courseId) {
        chooseCourseRepository.deleteByStudentAndCourse(studentRepository.findById(userId),courseRepository.findById(courseId));
        List<BChooseCourse> chooseCourses = chooseCourseRepository.findByStudentAndCourse(studentRepository.findById(userId),courseRepository.findById(courseId));
        return chooseCourses.size()==0;
    }

    @Override
    public String getAllSelect() {
        List<StuCourse> list=new ArrayList<>();
        List<BChooseCourse> bChooseCourses = chooseCourseRepository.findAll();
        for (int i=0;i<bChooseCourses.size();i++){
            StuCourse stuCourse = new StuCourse(bChooseCourses.get(i).getStudent().getId(),bChooseCourses.get(i).getCourse().getId());
            list.add(stuCourse);
        }
        return XmlUtils.toXml(list);
    }
    private String createOrdercheckId(){
        String id="";
        //获取当前时间戳
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String temp = sf.format(new Date());
        //获取随机数
        int random=(int) ((Math.random()+1)*1000);
        id=temp+random;
        return id;

    }
}
