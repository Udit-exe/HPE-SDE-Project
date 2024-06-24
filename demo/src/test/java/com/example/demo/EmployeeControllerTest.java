package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  public EmployeeManager empDao;

  public void testGetEmployees() throws Exception {
    List<Employee> employeeList = new ArrayList<>();
    employeeList.add(new Employee("1", "Aman", "Singh", "chapradreams@gmail.com", "Manager"));
    employeeList.add(new Employee("2", "Rajesh", "Kumar", "abc@gmail.com", "Assistant"));
    employeeList.add(new Employee("3", "Sam", "George", "sam4lyf@gmail.com", "Developer"));

    Employees employees = new Employees();
    employees.setEmployee(employeeList);

    when(empDao.getAllEmployees()).thenReturn(employees.getEmployees());

    mockMvc.perform(get("/employees/")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.employees.length()").value(3))
        .andExpect(jsonPath("$.employees[0].firstName").value("Aman"))
        .andExpect(jsonPath("$.employees[1].firstName").value("Rajesh"))
        .andExpect(jsonPath("$.employees[2].firstName").value("Sam"));
  }

  
  @Test
  public void testAddEmployee() throws Exception {
    Employee employee = new Employee("4", "New", "Employee", "new.employee@ple.com", "Tester");

    Mockito.doNothing().when(empDao).addEmployee(Mockito.any(Employee.class));

    mockMvc.perform(post("/employees/")
        .contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(employee)))
        .andExpect(status().isCreated());
  }
}
