package com.example.homework_2.sql_server;

import com.example.homework_2.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoSqlServerImplTest {

    @Autowired
    @Qualifier("studentDaoSqlServerImpl")
    StudentDao studentDao;

    @Test
    public void getAllStudent() {
        assertEquals("",studentDao.getAllStudent());
    }

//    @Test
//    public void addStudent() {
//
//    }
}