package com.learning.employeescatalog.service;

import com.learning.employeescatalog.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
