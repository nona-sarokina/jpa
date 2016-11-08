package api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;

/**
 * Created by user on 07.11.2016.
 */
public class UnitDAO implements IBaseModelDAO<Unit>, IUnitModelDAO {
    protected EntityManager entityManager;

    public UnitDAO() {
        this.entityManager = Persistence.createEntityManagerFactory(name).createEntityManager();
    }

    public void create(Unit object) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();

    }


    public Unit find(String id) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Unit unit = entityManager.find(Unit.class, id);
        transaction.commit();

        return unit;
    }

    public void delete(String id) {
        Unit object = entityManager.find(Unit.class, id);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(object);
        transaction.commit();

    }

    public Unit update(String id, Unit object) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        transaction.commit();
        return object;
    }


    public void addEmployee(String id, Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        Unit object = entityManager.find(Unit.class, id);
        if (object.getEmployees() == null) {
            object.setEmployees(new ArrayList<Employee>());
        }
        transaction.begin();
        object.getEmployees().add(employee);
        transaction.commit();
    }
}
