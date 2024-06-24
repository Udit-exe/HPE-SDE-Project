package com.example.demo;

import java.util.*;


public class Employees {

  private List<Employee> employeeList;  

  public Employees(){}

  public Employees(List<Employee> emps){
    for(Employee emp : emps){
      employeeList.add(emp);
    }
  }

  public List<Employee> getEmployees(){
    if(employeeList == null){
      employeeList = new ArrayList<>();
    }

    return employeeList;
  }

  //for multiple employees
  public void setEmployee(Employee emp){
    this.employeeList.add(emp);
  }
  public void setEmployee(List<Employee> emp){
    this.employeeList = emp;
  }
  
}
