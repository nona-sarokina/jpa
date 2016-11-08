package jmp.jpa.model.utils;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.11.2016.
 */
public class UnitCreator {

    public static Unit createUnitWithoutEmployees() {
        Unit unit = new Unit();
        unit.setName("Unit name");
        return unit;
    }

    public static Unit createUnitWithEmployees() {
        Unit unit = createUnitWithoutEmployees();
        List<Employee> employees = new ArrayList<Employee>();

        employees.add(EmployeeCreator.createEmployeeForUnit(unit));
        employees.add(EmployeeCreator.createEmployeeForUnit(unit));
        employees.add(EmployeeCreator.createEmployeeForUnit(unit));

        unit.setEmployees(employees);

        return unit;
    }
}
