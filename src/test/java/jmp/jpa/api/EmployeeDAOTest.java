package jmp.jpa.api;

import jmp.jpa.model.utils.EmployeeCreator;
import jmp.jpa.models.Employee;
import jmp.jpa.models.Personal;
import jmp.jpa.models.Project;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

/**
 * Created by user on 07.11.2016.
 */
public class EmployeeDAOTest {
    Employee employee;
    EmployeeDAO dao;

    @Before
    public void setUp() throws Exception {
        employee = EmployeeCreator.createEmployee();
        dao = new EmployeeDAO();
        dao.create(employee);
    }

    @After
    public void tearDown() throws Exception {
        dao.close();
    }

    @Test
    public void idForCreatedEmployeeWasGenerated() throws Exception {
        assertNotNull(employee.getId());
    }

    @Test
    public void createdPersonalDataInserted() throws Exception {
        assertNotNull(employee.getPersonal());
        Personal personal = dao.entityManager.find(Personal.class, employee.getPersonal().getId());
        assertEquals(employee.getPersonal(), personal);
    }

    @Test
    public void employeeProjectsHasNoProjects() throws Exception {
        assertNull(employee.getProjectList());
    }

    @Test
    public void employeeProjectsHasSameEmployee() throws Exception {
        employee = EmployeeCreator.createEmployeeWithProject();
        dao.create(employee);

        for (Project project : employee.getProjectList()) {
            assertThat(project.getEmployeeList(), hasItem(employee));
        }
    }

    @Test
    public void find() throws Exception {
        employee = EmployeeCreator.createEmployeeWithProject();
        dao.create(employee);
        Employee foundEmployee = dao.find(this.employee.getId());

        assertEquals(this.employee, foundEmployee);

    }

    @Test
    public void delete() throws Exception {
        dao.delete(employee.getId());
        assertNull(dao.find(employee.getId()));
    }

    @Test
    public void update() throws Exception {
        employee.setLastname("changed lastname");
        dao.update(employee.getId(), employee);
        assertEquals("changed lastname", employee.getLastname());
    }

}