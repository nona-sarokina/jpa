package api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

/**
 * Created by user on 07.11.2016.
 */
public class ProjectDAO implements IBaseModelDAO<Project>, IProjectModelDAO {
    protected EntityManager entityManager;

    public ProjectDAO() {
        entityManager = Persistence.createEntityManagerFactory(name).createEntityManager();
    }


    public void create(Project object) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();

    }


    public Project find(String id) {

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Project project = entityManager.find(Project.class, id);
        transaction.commit();

        return project;
    }

    public void delete(String id) {
        Project object = entityManager.find(Project.class, id);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(object);
        transaction.commit();

    }

    public Project update(String id, Project object) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        transaction.commit();
        return object;
    }


    public void assignEmployee(String id, Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        Project object = entityManager.find(Project.class, id);
        if (object.getEmployeeList() == null) {
            object.setEmployeeList(new ArrayList<Employee>());
        }
        transaction.begin();
        object.getEmployeeList().add(employee);
        transaction.commit();
    }
}
