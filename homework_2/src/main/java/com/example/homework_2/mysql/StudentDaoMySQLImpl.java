package com.example.homework_2.mysql;

import com.example.homework_2.dao.StudentDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.Student;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("studentDaoMySQLImpl")
@Qualifier("studentDaoMySQLImpl")
public class StudentDaoMySQLImpl implements StudentDao {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @Override
    public String getAllStudent() {

        List<Student> list=new ArrayList<>();
        List rows=jdbcTemplate.queryForList("select * from students");
        Iterator it = rows.iterator();
        while(it.hasNext()) {
            Map m=(Map)it.next();
            Student  stu=new Student((String)m.get("number"),(String)m.get("password"),(String)m.get("name"),"建筑学院");
            list.add(stu);
        }
        return XmlUtils.toXml(list);
    }

    @Override
    public boolean addStudent(String userId, String name) {
        int res=jdbcTemplate.update("insert into students(number,name) values(?,?)",userId,name);
        return res>0;
    }
}
