package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Employee;
import com.test.model.Employees;
import com.test.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping(value = "/empcreate", consumes="application/json")
	public List<Employee> createEmployee(@RequestBody Employee emp)
	{
		int i = service.readAllEmployees().size()+1;
		emp.setId(i);
		service.createEmployee(emp);
		return service.readAllEmployees();
	}
	
	@GetMapping(value = "/readAll" , produces = "application/json")
	public List<Employee> getAllEmployees()
	{
		return service.readAllEmployees();
	}
	
	@PutMapping(value = "/update/{id}" , consumes = "application/json")
	public List<Employee> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id)
	{
		emp.setId(id);
		service.updateEmployee(emp);
		return service.readAllEmployees();
	}
	
	@DeleteMapping(value = "/delete/{id}", produces="application/json")
	public List<Employee> deleteEmployee(@PathVariable("id") int id)
	{
		service.deleteEmployee(id);
		return service.readAllEmployees();
	}
	
	
}
