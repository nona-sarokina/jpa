package api;

import jmp.jpa.models.Employee;
import jmp.jpa.models.Unit;
import model.utils.EmployeeCreator;
import model.utils.UnitCreator;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

/**
 * Created by user on 08.11.2016.
 */
public class UnitDAOTest {
    Unit unit;
    UnitDAO dao;

    @Before
    public void setUp() throws Exception {
        unit = UnitCreator.createUnitWithEmployees();
        dao = new UnitDAO();
        dao.create(unit);
    }

    @Test
    public void idForCreatedUnitWasGenerated() throws Exception {
        assertNotNull(unit.getId());
    }
    @Test
    public void allRelatedEmployeesHasCurrentUnit() throws Exception {
        for (Employee employee : unit.getEmployees()) {
            assertEquals(employee.getUnit(), unit);
        }
    }

    @Test
    public void find() throws Exception {
        Unit foundUnit = dao.find(unit.getId());
        assertEquals(unit, foundUnit);
    }

    @Test
    public void delete() throws Exception {
        dao.delete(unit.getId());
        assertNull(dao.find(unit.getId()));
    }

    @Test
    public void update() throws Exception {
        unit.setName("New name");
        dao.update(unit.getId(), unit);
        assertEquals("New name", unit.getName());
    }


    @Test
    public void addingEmployeeToAnEmptyListOfEmployees() throws Exception {
        unit = UnitCreator.createUnitWithoutEmployees();
        dao.create(unit);
        Unit foundUnit = dao.find(unit.getId());
        Employee employeeWithProject = EmployeeCreator.createEmployeeForUnit(foundUnit);
        dao.addEmployee(foundUnit.getId(), employeeWithProject);
        assertThat(foundUnit.getEmployees(), hasItem(employeeWithProject));
    }

    @Test
    public void addingEmployeeToNotEmptyListOfEmployees() throws Exception {
        Unit foundUnit = dao.find(unit.getId());
        Employee employeeWithProject = EmployeeCreator.createEmployeeForUnit(foundUnit);
        dao.addEmployee(foundUnit.getId(), employeeWithProject);
        assertThat(foundUnit.getEmployees(), hasItem(employeeWithProject));
    }

}