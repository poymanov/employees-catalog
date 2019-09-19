package com.learning.employeescatalog.rest;

import com.learning.employeescatalog.dao.EmployeeDAO;
import com.learning.employeescatalog.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

}
