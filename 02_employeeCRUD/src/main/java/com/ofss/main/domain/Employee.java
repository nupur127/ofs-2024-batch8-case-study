package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="employee_details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
private int employeeId ;
	@Column(name = "first_name")
private String first_name; 
	@Column(name = "last_name")
private String last_name; 
	@Column(name = "salary")
private double salary;

public Employee(int employeeId, String first_name, String last_name, double salary) {
	super();
	this.employeeId = employeeId;
	this.first_name = first_name;
	this.last_name = last_name;
	this.salary = salary;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", first_name=" + first_name + ", last_name=" + last_name
			+ ", salary=" + salary + "]";
}
public Employee() {
	super();
} 
}
