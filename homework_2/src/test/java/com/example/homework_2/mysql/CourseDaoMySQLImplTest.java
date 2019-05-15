package com.example.homework_2.mysql;

import com.example.homework_2.dao.CourseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDaoMySQLImplTest {
    @Autowired
    @Qualifier("courseDaoMySQLImpl")
    private CourseDao courseDaoMysql;

    @Test
    public void getAllCourse() {
        assertEquals("",courseDaoMysql.getAllCourse());
    }

    @Test
    public void selectCourse() {
        assertEquals(true,courseDaoMysql.selectCourse("A1","A1"));
    }

    @Test
    public void returnCourse() {
    }

    @Test
    public void getAllSelect() {
        assertEquals("",courseDaoMysql.getAllSelect());
    }
}