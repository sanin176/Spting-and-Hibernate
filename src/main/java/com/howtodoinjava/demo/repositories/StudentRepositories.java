package com.howtodoinjava.demo.repositories;

import com.howtodoinjava.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepositories extends JpaRepository<Student, Long> {
    List<Student> findAllByName(String name);
}
