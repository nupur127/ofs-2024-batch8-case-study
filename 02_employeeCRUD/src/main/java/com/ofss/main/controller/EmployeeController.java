package com.ofss.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.Repository.EmployeeRepository;
import com.ofss.main.domain.Employee;
import com.ofss.main.service.EmployeeService;
import com.ofss.main.service.EmployeeServiceImpl;

@RequestMapping("employeecrudapi")
@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService ;
	//http://localhost:8080/employeecrudapi/employees/1
	@GetMapping("employees/{employeeId}")
public Employee getEmployeeFromDB(@PathVariable int employeeId) {
	return employeeService.getEmployeeByEmployeeId(employeeId);
	
}
	@PostMapping("employees")
	public Employee addNewEmployeeToDB(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);
		
	}
	
	@PutMapping("employees")
	public Employee updateEmployeeToDB(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
		
	}
	
	@DeleteMapping("employees/{employeeId}")
	public boolean deleteEmployeeToDB(@PathVariable int  employeeId) {
		return employeeService.deleteEmployee(employeeId);
		
	}
	
	@GetMapping("employees")
	public List<Employee> getAllEmployeesFromDB() {
		return employeeService.getAllEmployees();
		
	}
}
