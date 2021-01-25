package com.coderzero.services;

import com.coderzero.models.Student;
import com.coderzero.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
//    private StudentHibernateDao studentHibernateDao;
    private StudentRepository studentRepository;

    //Cách làm thông thường
//    public void save(Student student){
//        studentHibernateDao.saveStudent(student);
//    }

    //Cach làm sử dụng repository của jpa
    public void save(Student student){
        studentRepository.save(student);
    }

    public void test(){
        System.out.println(studentRepository.count());
        System.out.println(studentRepository.findAll());
    }
}
