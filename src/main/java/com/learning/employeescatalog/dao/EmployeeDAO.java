package com.learning.employeescatalog.dao;

import com.learning.employeescatalog.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
