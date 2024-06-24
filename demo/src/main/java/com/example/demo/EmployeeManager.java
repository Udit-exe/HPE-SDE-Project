package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository; 

@Repository

public class EmployeeManager{
  private static Employees emps_list = new Employees();
  
  static{
    emps_list.getEmployees().add( 
      new Employee( 
        "1", "Aman", "Singh",  "chapradreams@gmail.com", "Manager")); 
  
    emps_list.getEmployees().add( 
          new Employee( 
        "2", "Rajesh", "Kumar", "abc@gmail.com" , "Assistant")); 
  
    emps_list.getEmployees().add( 
      new Employee( 
        "3", "Sam", "George", "sam4lyf@gmail.com", "Developer")); 
  }
  
  public List<Employee> getAllEmployees(){
    return emps_list.getEmployees();
  }

  public void addEmployee(Employee emp){
    emps_list.setEmployee(emp);
  }
  public void addEmployee(List<Employee> emps){
    emps_list.setEmployee(emps);
  }
}
