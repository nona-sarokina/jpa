package jmp.jpa.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 06.11.2016.
 */
@Entity
public class Project {
    String name;
    String description;
    @Id
    @GeneratedValue
    private String id;

    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "projectList")
    private List<Employee> employeeList;


    public Project() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

}
