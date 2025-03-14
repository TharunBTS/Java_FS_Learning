package com.test.model;

public class Employee {
	
	private Integer id;
	private String name;
	private String cmp;
	
	public Employee()
	{
		
	}
	
	public Employee(Integer id, String name, String cmp) {
		this.id = id;
		this.name = name;
		this.cmp = cmp;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCmp() {
		return cmp;
	}
	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cmp=" + cmp + "]";
	}
	
	
	
	
}
