package jmp.jpa.api;

import jmp.jpa.models.Employee;

/**
 * Created by user on 07.11.2016.
 */
public interface IProjectModelDAO {

    void assignEmployee(String id, Employee employee);

}
