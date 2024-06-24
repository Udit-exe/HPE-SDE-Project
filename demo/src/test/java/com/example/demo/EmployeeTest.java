package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
  
  @Test
  public void testEmployeeConst(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    assertEquals(emp.getId(), "1");
    assertEquals(emp.getFirstName(), "John");
    assertEquals(emp.getLastName(), "Doe");
    assertEquals(emp.getTitle(), "Hod");
    assertEquals(emp.getEmail(), "John@mail.com");
  }

  @Test
  public void testSetId(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    emp.setId("2");
    assertEquals("2", emp.getId());
  }
  @Test
  public void testSetF_n(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    emp.setFirstName("Jimmy");
    assertEquals("Jimmy", emp.getFirstName());
  }
  @Test
  public void testSetL_n(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    emp.setLastName("Jason");
    assertEquals("Jason", emp.getLastName());
  }
  @Test
  public void testSetEmail(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    emp.setEmail("Jimmy@mailme.com");
    assertEquals("Jimmy@mailme.com", emp.getEmail());
  }
  @Test
  public void testSetTitle(){
    Employee emp = new Employee("1","John" , "Doe","John@mail.com","Hod");
    emp.setTitle("Enginner");
    assertEquals("Enginner", emp.getTitle());
  }
}
