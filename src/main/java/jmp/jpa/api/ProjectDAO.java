package jmp.jpa.api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Project;

import javax.persistence.EntityTransaction;
import java.util.ArrayList;

/**
 * Created by user on 07.11.2016.
 */
public class ProjectDAO extends BaseModelDAO<Project> implements IProjectModelDAO {

    public void assignEmployee(String id, Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        Project object = entityManager.find(Project.class, id);
        if (object.getEmployeeList() == null) {
            object.setEmployeeList(new ArrayList<Employee>());
        }
        try {
            transaction.begin();
            object.getEmployeeList().add(employee);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }

            e.printStackTrace();
        }
    }

    @Override
    protected Class<Project> getTypeClass() {
        return Project.class;
    }
}
