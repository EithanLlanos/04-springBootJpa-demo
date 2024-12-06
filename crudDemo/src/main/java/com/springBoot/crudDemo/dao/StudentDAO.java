package com.springBoot.crudDemo.dao;

import com.springBoot.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    //Method to search on DB by Id
    Student findById(Integer id);

    //Method to retrieve all
    List<Student> findAll();
}
