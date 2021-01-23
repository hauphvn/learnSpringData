package com.coderzero.dao;

import com.coderzero.models.Student;
import com.coderzero.util.MysqlJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;

@Component
public class StudentJDBCDAO {
    MysqlJDBC mysqlJDBC = new MysqlJDBC();
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean insertStudent(Student student) throws FileNotFoundException, SQLException {
        String sql = "insert into learn_hibernate.fresher(name) values(?)";
        try{
            jdbcTemplate.update(sql,student.getName());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Student getAStudent(int id){
        String sql = "select s.id, s.name from learn_hibernate.fresher s where s.id = ?";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentMapper());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAll(){
        String sql = "select s.id, s.name from learn_hibernate.fresher  s";
        try{
            return jdbcTemplate.query(sql, new StudentMapper());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static final class StudentMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setName(resultSet.getString("name"));
            student.setId(resultSet.getInt("id"));
            return student;
        }
    }
}
