package com.ofss.main.service;

import java.util.List;

import com.ofss.main.domain.Employee;

public interface EmployeeService {
public Employee getEmployeeByEmployeeId(int employeeId);
public Employee addNewEmployee(Employee employee);
public Employee updateEmployee(Employee employee);
public boolean deleteEmployee(int employeeId);
public List<Employee> getAllEmployees(); 
}
