package com.test.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.model.Employee;
import com.test.model.Employees;


@Repository
@Service
public class EmployeeService implements EmployeeDao {
	
	
	private static Employees empData = new Employees();
	
	static
	{
		empData.getEmpList().add(new Employee(1,"Rohit","ICC"));
		empData.getEmpList().add(new Employee(2,"Rahul","BCCI"));
		empData.getEmpList().add(new Employee(3,"kholi","IPL"));
		empData.getEmpList().add(new Employee(4,"Sky","BCC"));
		empData.getEmpList().add(new Employee(5,"Dhoni","ICC"));
		empData.getEmpList().add(new Employee(6,"Albie","IPL"));
	}
	
	@Override
	public Employee createEmployee(Employee emp)
	{
		empData.getEmpList().add(emp);
		return emp;
	}
	
	@Override
	public List<Employee> readAllEmployees()
	{
		return empData.getEmpList();
	}
	
	@Override
	public String updateEmployee(Employee emp)
	{
		int i=0;
		for(Employee e : empData.getEmpList())
		{
			if(e.getId() == emp.getId())
			{
				empData.getEmpList().set(i, emp);
			}
			i++;
		}
		
		return "the given id is not available";
	}
	
	@Override
	public String deleteEmployee(Integer id)
	{
		int i=0;
		for(Employee e : empData.getEmpList())
		{
			if(e.getId() == id)
			{
				empData.getEmpList().remove(i);
			}
			i++;
		}
		
		return "the given id is not available";
	}

}
