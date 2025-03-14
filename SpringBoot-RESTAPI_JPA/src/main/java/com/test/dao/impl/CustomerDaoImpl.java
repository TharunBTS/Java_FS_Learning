package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.CustomerDao;
import com.test.entity.Customer;
import com.test.repository.CustomerRepository;



@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	@Autowired
	private CustomerRepository repo;
	
	
	
	

	public void setRepo(CustomerRepository repo) {
		this.repo = repo;
	}

	@Override
	public Customer createCustomer(Customer cst) {
		
		return repo.save(cst);
	}

	@Override
	public List<Customer> readAllCustomers() {
		
		return repo.findAll();
	}

	@Override
	public List<Customer> updateCustomer(Customer cst) {
		
		repo.save(cst);
		return repo.findAll();
	}

	@Override
	public List<Customer> deleteCustomer(int id) {
		
		repo.deleteById(id);
		return repo.findAll();
	}

}
