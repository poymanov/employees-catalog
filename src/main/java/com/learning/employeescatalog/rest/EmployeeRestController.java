package com.learning.employeescatalog.rest;

import com.learning.employeescatalog.dao.EmployeeDAO;
import com.learning.employeescatalog.entity.Employee;
import com.learning.employeescatalog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }
}
