package jmp.jpa.api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Unit;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;

/**
 * Created by user on 07.11.2016.
 */
public class UnitDAO extends BaseModelDAO<Unit> implements IUnitModelDAO {

    public void addEmployee(String id, Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        Unit object = entityManager.find(Unit.class, id);
        if (object.getEmployees() == null) {
            object.setEmployees(new ArrayList<Employee>());
        }
        try {
            transaction.begin();
            object.getEmployees().add(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    @Override
    protected Class<Unit> getTypeClass() {
        return Unit.class;
    }
}
