package com.example.homework_2.mysql;

import com.example.homework_2.dao.CourseDao;
import com.example.homework_2.model.Course;
import com.example.homework_2.model.StuCourse;
import com.example.homework_2.utils.XmlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component("courseDaoMySQLImpl")
@Qualifier("courseDaoMySQLImpl")
public class CourseDaoMySQLImpl implements CourseDao {
    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @Override
    public String getAllCourse() {
        List<Course> list=new ArrayList<>();
        List rows=jdbcTemplate.queryForList("select * from courses");
        Iterator it = rows.iterator();
        while(it.hasNext()) {
            Map m=(Map)it.next();
            Course course=new Course((String)m.get("number"),(String)m.get("name"));
            list.add(course);
        }
        return XmlUtils.toXml(list);
    }

    @Override
    public boolean selectCourse(String userId, String courseId) {
        int res=jdbcTemplate.update("insert  into stucourses(studentNumber, courseNumber) values(?,?)",userId,courseId);
        return res>0;
    }

    @Override
    public boolean returnCourse(String userId, String courseId) {
        int res=jdbcTemplate.update("delete from stucourses where studentNumber=? and courseNumber=?",userId, courseId);
        return res>0;
    }

    @Override
    public String getAllSelect() {
        List<StuCourse> list=new ArrayList<>();
        List rows=jdbcTemplate.queryForList("select * from stucourses");
        Iterator it = rows.iterator();
        while(it.hasNext()) {
            Map m=(Map)it.next();
            StuCourse stuCourse=new StuCourse((String)m.get("studentNumber"),(String)m.get("courseNumber"));
            list.add(stuCourse);
        }
        return XmlUtils.toXml(list);
    }
}
