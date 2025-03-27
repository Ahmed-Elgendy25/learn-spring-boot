package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAO_JPA_Imp  implements EmployeeDAO {

    //define fields for entity
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAO_JPA_Imp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class) ;
        //execute query and get list of results

        List<Employee> employees = theQuery.getResultList();
        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save or update the employee
        Employee savedEmployee = entityManager.merge(theEmployee);
        //return the saved employee
        return savedEmployee;
    }

    @Override
    public void deleteById(int theId) {
        //get employee
        Employee employee=findById(theId);
        // delete the employee
        entityManager.remove(employee);
    }
}
