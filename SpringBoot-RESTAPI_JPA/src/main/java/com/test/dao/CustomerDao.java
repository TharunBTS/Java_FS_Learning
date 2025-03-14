package com.test.dao;

import java.util.List;

import com.test.entity.Customer;

public interface CustomerDao  {
	
	
	public Customer createCustomer(Customer cst);
	public List<Customer> readAllCustomers();
	public List<Customer> updateCustomer(Customer cst);
	public List<Customer> deleteCustomer(int id);
	
}
