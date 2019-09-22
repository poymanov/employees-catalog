package com.learning.employeescatalog.dao;

import com.learning.employeescatalog.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

@Repository
public class EmployeeDAOJpa implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpa(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return (entityManager.createQuery("from Employee")).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Employee savedEmployee = entityManager.merge(employee);
        employee.setId(savedEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:id");
        query.setParameter("id", id);
    }
}
