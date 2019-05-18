package com.example.homework_2.oracle.daoImpl;

import com.example.homework_2.dao.CourseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoOracleImplTest {
    @Autowired
    @Qualifier("courseDaoOracleImpl")
    CourseDao courseDao;
    @Test
    public void getAllCourse() {
        assertEquals("",courseDao.getAllCourse());
    }

//    @Test
//    public void selectCourse() {
//    }
//
//    @Test
//    public void returnCourse() {
//    }

    @Test
    public void getAllSelect() {
        assertEquals("",courseDao.getAllSelect());
    }
}