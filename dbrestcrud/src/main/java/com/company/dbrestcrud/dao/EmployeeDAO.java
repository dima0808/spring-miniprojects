package com.company.dbrestcrud.dao;

import com.company.dbrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> readAll();

    Employee read(int id);

    Employee save(Employee employee);

    void delete(int id);
}
