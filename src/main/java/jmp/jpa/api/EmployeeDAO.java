package jmp.jpa.api;

import jmp.jpa.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.Closeable;
import java.io.IOException;

/**
 * Created by user on 07.11.2016.
 */
public class EmployeeDAO extends BaseModelDAO<Employee> {

    @Override
    protected Class<Employee> getTypeClass() {
        return Employee.class;
    }
}
