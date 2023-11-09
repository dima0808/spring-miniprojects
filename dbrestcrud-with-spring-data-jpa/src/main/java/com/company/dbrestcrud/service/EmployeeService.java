package com.company.dbrestcrud.service;

import com.company.dbrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee find(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
