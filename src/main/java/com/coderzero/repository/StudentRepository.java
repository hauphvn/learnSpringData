package com.coderzero.repository;

import com.coderzero.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByIdOrName(int id, String location);
    @Query("select s from Student s where s.name like '?'")
    Student fintBySpecialName(String name);
}
