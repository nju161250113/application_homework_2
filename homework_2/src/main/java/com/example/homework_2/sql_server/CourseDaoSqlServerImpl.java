package com.example.homework_2.sql_server;

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

@Component("courseDaoSqlServerImpl")
@Qualifier("courseDaoSqlServerImpl")
public class CourseDaoSqlServerImpl implements CourseDao {
    @Autowired
    @Qualifier("sqlServerJdbcTemplate")
    protected JdbcTemplate jdbcTemplate;

    @Override
    public String getAllCourse() {
        List<Course> courses = new ArrayList<>();
        List rows = jdbcTemplate.queryForList("select * from dbo.courses;");
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map map = (Map) iterator.next();
            Course course = new Course((String) map.get("cid"), (String) map.get("name"));
            courses.add(course);
        }

        return XmlUtils.toXml(courses);
    }

    @Override
    public boolean selectCourse(String userId, String courseId) {
        int result = jdbcTemplate.update("insert into dbo.choose_course(sid, cid) values('" + userId + "','" + courseId + "')");
        return result > 0;
    }

    @Override
    public boolean returnCourse(String userId, String courseId) {
        int result = jdbcTemplate.update("delete from dbo.choose_course where sid='" + userId + "' and cid='" + courseId + "'");
        return result > 0;
    }

    @Override
    public String getAllSelect() {
        List<StuCourse> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList("select * from dbo.choose_course");
        Iterator it = rows.iterator();
        while (it.hasNext()) {
            Map m = (Map) it.next();
            StuCourse stuCourse = new StuCourse((String) m.get("sid"), (String) m.get("cid"));
            list.add(stuCourse);
        }
        return XmlUtils.toXml(list);
    }
}
