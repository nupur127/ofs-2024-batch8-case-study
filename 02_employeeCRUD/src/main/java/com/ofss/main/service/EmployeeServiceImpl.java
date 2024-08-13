package com.ofss.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Employee;
import com.ofss.main.Repository.EmployeeRepository;
@Component
public class EmployeeServiceImpl implements EmployeeService{

@Autowired
private EmployeeRepository employeeRepository;
@Override
public Employee getEmployeeByEmployeeId(int employeeId) {
Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
if(employeeOptional.isPresent()) {
return employeeOptional.get();
}
return null;
}
@Override
public Employee addNewEmployee(Employee employee) {
	// TODO Auto-generated method stub
	return employeeRepository.save(employee);
}
@Override
public Employee updateEmployee(Employee employee) {
	return employeeRepository.save(employee);
	
}
@Override
public boolean deleteEmployee(int employeeId) {
	Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
	if(employeeOptional.isPresent()) {
		Employee employee = employeeOptional.get();
		employeeRepository.delete(employee);
		return true;
		
	}
	return false;
}
@Override
public List<Employee> getAllEmployees() {
	List<Employee> listOfEmployees =(List<Employee>) employeeRepository.findAll();
	return listOfEmployees;
	
}

}
