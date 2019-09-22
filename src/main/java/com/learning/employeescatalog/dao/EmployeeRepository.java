package com.learning.employeescatalog.dao;

import com.learning.employeescatalog.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
