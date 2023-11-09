package com.company.dbrestcrud.service;

import com.company.dbrestcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> readAll();

    Employee read(int id);

    Employee save(Employee employee);

    void delete(int id);
}
