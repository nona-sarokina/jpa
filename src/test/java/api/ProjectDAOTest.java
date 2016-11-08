package api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Project;
import model.utils.EmployeeCreator;
import model.utils.ProjectCreator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

/**
 * Created by user on 08.11.2016.
 */
public class ProjectDAOTest {
    Project project;
    ProjectDAO dao;

    @Before
    public void setUp() throws Exception {
        project = ProjectCreator.createProject();
        dao = new ProjectDAO();
        dao.create(project);
    }

    @Test
    public void idForCreatedProjectWasGenerated() throws Exception {
        assertNotNull(project.getId());
    }

    @Test
    public void employeeProjectsHasNoEmployees() throws Exception {
        assertNull(project.getEmployeeList());
    }

    @Test
    public void projectEmployeesProjectsHasSameProject() throws Exception {
        project = ProjectCreator.createProjectWithEmployees();
        dao.create(project);

        for (Employee employee: project.getEmployeeList()) {
            assertThat(employee.getProjectList(), hasItem(project));
        }
    }


    @Test
    public void find() throws Exception {
        Project foundProject = dao.find(project.getId());
        assertEquals(project, foundProject);
    }

    @Test
    public void delete() throws Exception {
        dao.delete(project.getId());
        assertNull(dao.find(project.getId()));
    }

    @Test
    public void update() throws Exception {
        project.setName("New name");
        dao.update(project.getId(), project);
        assertEquals("New name", project.getName());
    }

    @Test
    public void addingEmployeeToAnEmptyListOfEmployees() throws Exception {
        Project foundProject = dao.find(project.getId());
        dao.assignEmployee(foundProject.getId(), EmployeeCreator.createEmployee());
        Employee employeeWithProject = EmployeeCreator.createEmployeeWithProject(foundProject);
        dao.assignEmployee(foundProject.getId(), employeeWithProject);
        assertThat(foundProject.getEmployeeList(), hasItem(employeeWithProject));
    }

    @Test
    public void addingEmployeeToNotEmptyListOfEmployees() throws Exception {
        project = ProjectCreator.createProjectWithEmployees();
        dao.create(project);
        Project foundProject = dao.find(project.getId());
        Employee employeeWithProject = EmployeeCreator.createEmployeeWithProject(foundProject);
        dao.assignEmployee(foundProject.getId(), employeeWithProject);
        assertThat(foundProject.getEmployeeList(), hasItem(employeeWithProject));
    }

}