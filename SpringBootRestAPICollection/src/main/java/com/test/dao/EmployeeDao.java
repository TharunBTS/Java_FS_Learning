package com.test.dao;

import java.util.List;

import com.test.model.Employee;

public interface EmployeeDao {
	
	
	public Employee createEmployee(Employee emp);
	public String updateEmployee(Employee emp);
	public List<Employee> readAllEmployees();
	public String deleteEmployee(Integer id);

}
