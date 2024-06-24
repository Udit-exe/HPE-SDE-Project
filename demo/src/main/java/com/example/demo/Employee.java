package com.example.demo;

public class Employee{
  private String employee_id;
  private String first_name;
  private String last_name;
  private String email;
  private String title;

  //Default Constructor
  public Employee(){}

  //Parameterised constructor
  public  Employee(String id, String fn ,String ln , String em, String ti){
    this.employee_id = id;
    this.first_name = fn;
    this.last_name = ln;
    this.email = em;
    this.title = ti;
  }

  @Override 
  public String toString(){
    return "Employee [id = "+ employee_id + "firstName = " + first_name +"lastName = " + last_name + "email = " + email+ "Title = "+ title + "]"; 
  }

  public String getId(){  
    return employee_id; 
  }
  public void setId(String id){
    this.employee_id = id;
  }

  public String getFirstName(){
    return first_name;
  }
  public void setFirstName(String fn){
    this.first_name = fn;
  }

  public String getLastName(){
    return last_name;
  }
  public void setLastName(String ln){
    last_name = ln;
  }

  public String getEmail(){
    return email;
  }
  public void setEmail(String em){
    this.email = em;
  }

  public String getTitle(){
    return title;
  }
  public void setTitle(String ti){
    this.title = ti;
  }
}