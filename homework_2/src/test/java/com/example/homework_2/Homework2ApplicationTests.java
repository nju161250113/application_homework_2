package com.example.homework_2;

import com.example.homework_2.entity.Student;
import com.example.homework_2.repository.StudentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Homework2ApplicationTests {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void test() throws Exception {

        // 往第一个数据源中插入两条数据
        jdbcTemplate1.update("insert into students(name,password) values(?, ?)", "邵靖", "aaa");

//        // 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
        jdbcTemplate2.update("insert into goods(name,price,quantity) values(?, ?,?)", "兰州拉面",20.00,100);

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("13", jdbcTemplate1.queryForObject("select count(1) from students", String.class));

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("13", jdbcTemplate2.queryForObject("select count(1) from goods", String.class));

    }
    @Test
    public void test2(){
        Student student = studentRepository.findById("B1");
        Assert.assertEquals("123",student.getPassword());
    }


}
