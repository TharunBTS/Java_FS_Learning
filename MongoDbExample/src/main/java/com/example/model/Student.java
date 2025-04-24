package com.example.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "student")
public class Student {
	private String name;
	private String dept;
	private List<String> skills;
	
	Student(String name, String dept,List<String> skills)
	{
		this.name = name;
		this.dept = dept;
		this.skills = skills;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", dept=" + dept + ", skills=" + skills + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
}
