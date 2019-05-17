package com.example.homework_2.oracle.daoImpl;

import com.example.homework_2.dao.StudentDao;
import com.example.homework_2.model.Student;
import com.example.homework_2.oracle.entity.BStudent;
import com.example.homework_2.oracle.repository.StudentRepository;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("studentDaoOracleImpl")
@Qualifier("studentDaoOracleImpl")
public class StudentDaoOracleImpl implements StudentDao {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public String getAllStudent() {
        List<BStudent> list1=studentRepository.findAll();
        List<Student> list=new ArrayList<>();
        for (int i=0;i<list1.size();i++){
            Student student = new Student(list1.get(i).getId(),list1.get(i).getPassword(),list1.get(i).getName(),"软件工程");
            list.add(student);
        }
        return XmlUtils.toXml(list);
    }

    @Override
    public boolean addStudent(String userId, String name) {
        BStudent student = new BStudent();
        student.setId(userId);
        student.setName(name);
        studentRepository.save(student);
        BStudent bStudent = studentRepository.findById(userId);
        return bStudent!=null;
    }
}
