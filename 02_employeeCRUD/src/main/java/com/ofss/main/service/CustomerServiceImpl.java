package com.ofss.main.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ofss.main.Repository.CustomerRepository;
import com.ofss.main.domain.Customer;


@Component
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
		return customerOptional.get();
		}
		return null;
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
//
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return  customerRepository.save(customer);
	}
//
	@Override
	public boolean deleteCustomer(int customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customerRepository.delete(customer);
			return true;		
		}
		return false;
	}
//
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listOfCustomers =(List<Customer>) customerRepository.findAll();
		return listOfCustomers;
	}
//


	@Override
	public boolean authenticate(String username, String password) {
		Customer customer = customerRepository.findByUsernameAndPassword(username,password);
		if(customer != null) {
			if(customer.getPassword() == password ) {
				System.out.println("user is logged in successfully");
				return true;
			}else {
				System.out.println("user didnt logged in");
			}
//		
		}
		return false;
	}

	@Override
	public Customer findByUsername(String username) {
		return customerRepository.findByUsername(username);
	}



	


	
	

}
