package com.learning.employeescatalog.dao;

import com.learning.employeescatalog.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query<Employee> query = getSession().createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        getSession().saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
         Query query = getSession().createQuery("delete from Employee where id=:id");
         query.setParameter("id", id);
         query.executeUpdate();
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
