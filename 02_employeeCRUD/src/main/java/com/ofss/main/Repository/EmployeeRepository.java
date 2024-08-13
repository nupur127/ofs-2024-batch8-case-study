package com.ofss.main.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ofss.main.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
