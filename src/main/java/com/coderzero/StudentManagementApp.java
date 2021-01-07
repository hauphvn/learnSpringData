package com.coderzero;

import com.coderzero.dao.StudentJDBCDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentManagementApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        StudentJDBCDAO studentJDBCDAO = context.getBean("studentJDBCDAO", StudentJDBCDAO.class);
    }
}
