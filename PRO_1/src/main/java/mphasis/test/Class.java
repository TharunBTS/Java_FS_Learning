package mphasis.test;

import java.util.List;

public class Class {
	
	private int id;
	private String name;
	private List<String> li;
	public Class()
	{
		
	}
	
	public Class(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	public Class(int id, String name,List<String> li)
	{
		this.id = id;
		this.name = name;
		this.li = li;
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

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", li=" + li + "]";
	}
	
	
	
	

}
