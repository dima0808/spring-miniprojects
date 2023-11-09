package com.company.dbrestcrud.rest;

import com.company.dbrestcrud.entity.Employee;
import com.company.dbrestcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> readAllEmployees() {
        return employeeService.readAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee readAllEmployees(@PathVariable int employeeId) {
        Employee employee = employeeService.read(employeeId);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " not found");
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        if (employeeService.read(employeeId) == null) {
            throw new EmployeeNotFoundException("Employee with id " + employeeId + " not found");
        }
        employeeService.delete(employeeId);
        return "Employee with id " + employeeId + " deleted";
    }
}
