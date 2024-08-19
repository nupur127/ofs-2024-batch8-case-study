package com.ofss.main.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ofss.main.domain.Customer;



@Component
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
   Customer findByUsernameAndPassword(String username , String password);
   
   Customer findByUsername(String username);
}
