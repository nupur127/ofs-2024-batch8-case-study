package com.ofss.main.controller;

import java.util.List;

import org.json.JSONObject;
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

import com.ofss.main.domain.Customer;
import com.ofss.main.service.CustomerService;

//import com.ofss.main.domain.Customer;

//import com.ofss.main.service.CustomerService;


@RequestMapping("customercrudapi")
@RestController
@CrossOrigin
public class CustomerController {
	@GetMapping("hello")
	public String sayHello() {
		return "Hello Nupur";
	}
	
	@Autowired
	private CustomerService customerService ;
//	http://localhost:8080/customercrudapi/employees/1
	@GetMapping("customers/{customerId}")
public Customer getCustomerFromDB(@PathVariable int customerId) {
	return customerService.getCustomerByCustomerId(customerId);}
	

	@PostMapping("register")
	public Customer addNewCustomerToDB(@RequestBody Customer customer) {
		return customerService.addNewCustomer(customer);
		
	}
	@PutMapping("customers")
	public Customer updateCustomerToDB(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
		
	}
	
	@DeleteMapping("customers/{customerId}")
	public boolean deleteEmployeeToDB(@PathVariable int  customerId) {
		return customerService.deleteCustomer(customerId);	
	}
	
	@GetMapping("customers")
	public List<Customer> getAllCustomersFromDB() {
		return customerService.getAllCustomer();
		
	}
	
	@PostMapping("login")
	public Boolean loginCustomer(@RequestBody String loginDetails) {
		JSONObject jsonObject = new JSONObject(loginDetails);
		Customer customer = customerService.findByUsername(jsonObject.getString("username"));
		System.out.println("Customer is"+ customer);
		if (customer != null) {
			System.out.println("The data in the DB is " + customer);
			String enteredPassword = customer.getPassword();
			System.out.println("Here");
			if (enteredPassword.equals(jsonObject.getString("passwrd"))) {
				return true;
			}
		}
		return false;
		
	}
	
}

