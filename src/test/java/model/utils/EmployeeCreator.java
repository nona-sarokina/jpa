package model.utils;

import jmp.jpa.models.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by user on 08.11.2016.
 */
public class EmployeeCreator {

    public static Employee createEmployee() {
        Employee employee = new Employee();
        employee.setAddress(createAddress());
        employee.setEmployeeStatus(EmployeeStatus.FIRED);
        employee.setFirstname("Name");
        employee.setLastname("lastName");
        employee.setPersonal(createPersonal());

        return employee;
    }

    public static Employee createEmployeeWithProject(Project project) {
        Employee employee = createEmployee();
        employee.setProjectList(new ArrayList<Project>());
        employee.getProjectList().add(project);
        return employee;
    }

    public static Employee createEmployeeWithProject() {
        Employee employee = createEmployee();
        employee.setProjectList(new ArrayList<Project>());
        Project project = ProjectCreator.createProject();
        project.setEmployeeList(new ArrayList<Employee>());
        project.getEmployeeList().add(employee);
        employee.getProjectList().add(project);
        return employee;
    }

    public static Employee createEmployeeForUnit(Unit unit) {
        Employee employee = createEmployee();
        employee.setUnit(unit);
        return employee;
    }

    private static Personal createPersonal() {
        Personal personal = new Personal();
        personal.setBirthdate(new Date());
        personal.setEmail("some_email@test.com");
        return personal;
    }

    public static Address createAddress() {
        Address address = new Address();
        address.setCity("City");
        address.setCountry("Country");
        address.setHouse("House");
        address.setStreet("Street");
        address.setZipCode("zipcode");
        return address;
    }



}
