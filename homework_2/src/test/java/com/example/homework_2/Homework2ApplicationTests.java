package com.example.homework_2;

import com.example.homework_2.oracle.entity.BStudent;
//import com.example.homework_2.mysql.repository.StudentsRepository;
import com.example.homework_2.oracle.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework2ApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
//    private StudentsRepository studentsRepository;

//    @Test
//    public void test2(){
//        com.example.homework_2.mysql.entity.Student student = studentsRepository.findById(1);
//        Assert.assertEquals("123",student.getPassword());
//    }
    @Test
    public void test4(){
        BStudent student = studentRepository.findById("B1");
        Assert.assertEquals("亚瑟",student.getName());
    }


}
