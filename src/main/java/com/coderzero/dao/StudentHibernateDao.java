package com.coderzero.dao;

import com.coderzero.models.Fresher;
import com.coderzero.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentHibernateDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Fresher fresher){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(fresher.getAddress());
        session.save(fresher);
        session.getTransaction().commit();
        session.close();
    }

    public void saveStudent(Student student){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
    }
}
