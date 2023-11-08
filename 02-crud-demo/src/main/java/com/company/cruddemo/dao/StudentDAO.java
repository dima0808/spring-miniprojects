package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student read(int id);

    List<Student> readAll();

    List<Student> readByLastName(String lastName);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
