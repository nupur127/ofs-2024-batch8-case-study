package com.ofss.main.domain;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer_details")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int  customer_id;
	@Column(name="first_name")
     private String first_name;
	@Column(name="last_name")
     private String last_name;
	@Column(name="approval_status")
     private String approval_status ;
	@Column(name="username")
     private String username;
	@Column(name="password")
     private String password;
     private int login_attempts;
    private String date_of_birth ;
    
    @CreatedDate
    private String registration_date ;
    private String email_id ;
private long phone_number ;
private String address ;

public Customer() {
	super();
}


public Customer(int customer_id, String first_name, String last_name,String username,String password, String approval_status, int login_attempts, String date_of_birth, String registration_date, String email_id,
        long phone_number, String address) {
    this.customer_id = customer_id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.username=username;
    this.password=password;
    this.approval_status = approval_status;
    this.login_attempts = login_attempts;
    this.date_of_birth = date_of_birth;
    this.registration_date = registration_date;
    this.email_id = email_id;
    this.phone_number = phone_number;
    this.address = address;
}

public Customer(String first_name, String last_name,  String date_of_birth, String email_id, long phone_number, String address) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.date_of_birth = date_of_birth;
    this.email_id = email_id;
    this.phone_number = phone_number;
    this.address = address;
}

public Customer(int customer_id, String username, String password) {
    this.customer_id = customer_id;
    this.username = username;
    this.password = password;
}
public int getCustomer_id() {
    return customer_id;
}
public void setCustomer_id(int customer_id) {
    this.customer_id = customer_id;
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
public String getApproval_status() {
    return approval_status;
}
public void setApproval_status(String approval_status) {
    this.approval_status = approval_status;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public int getLogin_attempts() {
    return login_attempts;
}
public void setLogin_attempts(int login_attempts) {
    this.login_attempts = login_attempts;
}
public String getDate_of_birth() {
    return date_of_birth;
}
public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
}
public String getRegistration_date() {
    return registration_date;
}
public void setRegistration_date(String registration_date) {
    this.registration_date = registration_date;
}
public String getEmail_id() {
    return email_id;
}
public void setEmail_id(String email_id) {
    this.email_id = email_id;
}
public long getPhone_number() {
    return phone_number;
}
public void setPhone_number(long phone_number) {
    this.phone_number = phone_number;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}
@Override
public String toString(){
    return "Customer [ID: "+customer_id+"] [Name: "+  first_name+" " + last_name+"] [Status: " + approval_status+"] [Login attempts: " + login_attempts +"] [Date of birth: " + date_of_birth +"] [Reg Date: " + registration_date+"] [Email Id: "+email_id+"] [Phone number: "+phone_number+"] [ Address: "+address+"]";
}
}

