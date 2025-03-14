package com.test.service;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer cst);
	public List<Customer> readAllCustomers();
	public List<Customer> updateCustomer(Customer cst); 
	public List<Customer> deleteCustomer(int id);
}
