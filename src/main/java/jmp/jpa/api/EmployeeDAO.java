package jmp.jpa.api;

import jmp.jpa.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by user on 07.11.2016.
 */
public class EmployeeDAO implements IBaseModelDAO<Employee> {
    protected EntityManager entityManager;

    public EmployeeDAO() {
        entityManager = Persistence.createEntityManagerFactory(name).createEntityManager();
    }


    public void create(Employee object) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();

    }


    public Employee find(String id) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Employee employee = entityManager.find(Employee.class, id);
        transaction.commit();

        return employee;
    }

    public void delete(String id) {
        Employee object = entityManager.find(Employee.class, id);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(object);
        transaction.commit();

    }

    public Employee update(String id, Employee object) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        transaction.commit();
        return object;
    }


}
