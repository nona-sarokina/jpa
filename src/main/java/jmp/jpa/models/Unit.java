package jmp.jpa.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by user on 06.11.2016.
 */
@Entity
public class Unit {
    String name;
    @Id
    @GeneratedValue
    private String id;

    @OneToMany(mappedBy = "unit", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
