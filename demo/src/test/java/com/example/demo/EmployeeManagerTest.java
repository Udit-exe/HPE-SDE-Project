package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

    private EmployeeManager empManager;

    @BeforeEach
    public void setUp() {
        empManager = new EmployeeManager();
    }

    @Test
    public void testGetAllEmployees() {
        Employees emps = new Employees();
        emps.setEmployee(empManager.getAllEmployees());
        assertEquals(3, emps.getEmployees().size());

        Employee firstEmployee = emps.getEmployees().get(0);
        assertEquals("5", firstEmployee.getId());
        assertEquals("Jane", firstEmployee.getFirstName());
        assertEquals("Doe", firstEmployee.getLastName());
        assertEquals("jane.doe@example.com", firstEmployee.getEmail());
        assertEquals("Designer", firstEmployee.getTitle());
    }

    @Test
    public void testAddEmployee() {
        Employee newEmployee = new Employee("4", "John", "Doe", "john.doe@example.com", "Tester");
        empManager.addEmployee(newEmployee);

        Employees employees = new Employees();
        employees.setEmployee(empManager.getAllEmployees());
        assertEquals(3, employees.getEmployees().size());

        Employee addedEmployee = employees.getEmployees().get(2);
        assertEquals("4", addedEmployee.getId());
        assertEquals("John", addedEmployee.getFirstName());
        assertEquals("Doe", addedEmployee.getLastName());
        assertEquals("john.doe@example.com", addedEmployee.getEmail());
        assertEquals("Tester", addedEmployee.getTitle());
    }

    @Test
    public void testAddMultipleEmployees() {
        List<Employee> newEmps = new ArrayList<>();
        newEmps.add(new Employee("5", "Jane", "Doe", "jane.doe@example.com", "Designer"));
        newEmps.add(new Employee("6", "Jack", "Smith", "jack.smith@example.com", "Developer"));

        empManager.addEmployee(newEmps);

        Employees employees = new Employees();
        employees.setEmployee(empManager.getAllEmployees());
        assertEquals(2, employees.getEmployees().size());

        Employee firstNewEmployee = employees.getEmployees().get(0);
        assertEquals("5", firstNewEmployee.getId());
        assertEquals("Jane", firstNewEmployee.getFirstName());
        assertEquals("Doe", firstNewEmployee.getLastName());
        assertEquals("jane.doe@example.com", firstNewEmployee.getEmail());
        assertEquals("Designer", firstNewEmployee.getTitle());

        Employee secondNewEmployee = employees.getEmployees().get(1);
        assertEquals("6", secondNewEmployee.getId());
        assertEquals("Jack", secondNewEmployee.getFirstName());
        assertEquals("Smith", secondNewEmployee.getLastName());
        assertEquals("jack.smith@example.com", secondNewEmployee.getEmail());
        assertEquals("Developer", secondNewEmployee.getTitle());
    }
}
