package api;

import jmp.jpa.models.Employee;

/**
 * Created by user on 07.11.2016.
 */
public interface IUnitModelDAO {

    void addEmployee(String id, Employee employee);

}
