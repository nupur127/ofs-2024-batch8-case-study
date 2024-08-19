package com.ofss.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;

@Service
public interface CustomerService {

		public Customer getCustomerByCustomerId(int customerId);
		public Customer addNewCustomer(Customer customer);
		public Customer updateCustomer(Customer customer);
		public boolean deleteCustomer(int customerId);
		public List<Customer> getAllCustomer(); 
		public Customer findByUsername(String username);
		public boolean authenticate(String username, String password);
}
