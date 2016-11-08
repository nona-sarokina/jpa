package jmp.jpa.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 06.11.2016.
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private String id;
    private String firstname;
    private String lastname;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;

    @OneToOne(cascade = {CascadeType.ALL})
    @PrimaryKeyJoinColumn
    private Personal personal;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "EmployeeProjects",
            joinColumns = @JoinColumn(name = "projectId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"))
    private List<Project> projectList;

    @ManyToOne
    @JoinColumn(name = "unit")
    private Unit unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

}

