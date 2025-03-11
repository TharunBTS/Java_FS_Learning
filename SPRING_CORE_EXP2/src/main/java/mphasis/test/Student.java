package mphasis.test;

import java.util.List;

public class Student {
	
	private int id;
	private String name;
	private List<String> skills;
	
	public Student()
	{
		
	}
	
	public Student(int id, String name, List<String> skills)
	{
		this.id = id;
		this.name = name;
		this.skills = skills;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}
	
	
	

}
