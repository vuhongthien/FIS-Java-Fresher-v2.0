package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeDAOJdbcTest {
    @Test
    public void testGetAll() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        List<Employee> employeeList = employeeDAO.getAll();

        System.out.println(employeeList);
    }

    @Test
    void add() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        Employee employee = new Employee(20, "Nguyen Thanh Nhan", 103.);

        assertTrue(employeeDAO.add(employee));

        //System.out.println(employeeDAO.getAll());
    }
    @Test
    void addAll() {
        IEmployeeDAO employeeDAO = new EmployeeDAOJdbc();
        List<Employee> l =new ArrayList<>();
        l.add(new Employee(9,"abc",2000));
        l.add(new Employee(10,"abc",2000));
        l.add(new Employee(11,"abc",2000));
        l.add(new Employee(12,"abc",2000));
        employeeDAO.addAll(l);
        System.out.println(employeeDAO.getAll());
    }

}