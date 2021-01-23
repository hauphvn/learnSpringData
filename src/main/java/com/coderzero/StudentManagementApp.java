package com.coderzero;

import com.coderzero.dao.StudentDaoSupport;
import com.coderzero.dao.StudentHibernateDao;
import com.coderzero.dao.StudentJDBCDAO;
import com.coderzero.models.Address;
import com.coderzero.models.Fresher;
import com.coderzero.models.Student;
import com.coderzero.util.MysqlJDBC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

public class StudentManagementApp {
    public static void main(String[] args) throws FileNotFoundException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        StudentJDBCDAO studentDAO = context.getBean("studentJDBCDAO", StudentJDBCDAO.class);
//        StudentDaoSupport studentDaoSupport = context.getBean("studentDaoSupport", StudentDaoSupport.class);
        StudentHibernateDao studentHibernateDao = context.getBean("studentHibernateDao", StudentHibernateDao.class);
//        Student student = new Student();
//        student.setName("Pham van hau 2");
//        System.out.println(studentDAO.insertStudent(student));

//        Student student = studentDAO.getAStudent(10);
//        if(null != student){
//            System.out.println(student);
//        }else{
//            System.out.println("Null student");
//        }

//        List<Student> listStudents = studentDaoSupport.getAllStudents();
//        if(null != listStudents){
//            System.out.println(listStudents);
//        }

        Fresher fresher = new Fresher();
        fresher.setName("Pham van hau 3");

        Address address = new Address();
        address.setDistrict("Quan 11");
        address.setStreet("Lac long quan");

        fresher.setAddress(address);

        studentHibernateDao.save(fresher);

    }
}
