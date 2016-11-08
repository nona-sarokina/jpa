package jmp.jpa.model.utils;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.11.2016.
 */
public class ProjectCreator {

    public static Project createProject() {
        Project project = new Project();
        project.setDescription("Project description");
        project.setName("Project name");
        return project;
    }


    public static Project createProjectWithEmployees() {
        Project project = createProject();
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(EmployeeCreator.createEmployeeWithProject(project));
        employeeList.add(EmployeeCreator.createEmployeeWithProject(project));
        employeeList.add(EmployeeCreator.createEmployeeWithProject(project));
        project.setEmployeeList(employeeList);
        return project;
    }

}
