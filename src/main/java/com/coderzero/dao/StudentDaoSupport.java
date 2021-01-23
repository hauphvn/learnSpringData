package com.coderzero.dao;

import com.coderzero.models.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoSupport extends JdbcDaoSupport {

    public List<Student> getAllStudents(){
        String sql = "select s.id, s.name from learn_hibernate.fresher s";
        return this.getJdbcTemplate().query(sql, new StudentMapper());
    }

    public static final class StudentMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            return student;
        }
    }
}
