import java.util.*;

public class samp_class {
	
	private int id;
	private String name;
	private int age;
	
	public samp_class()
	{
		
	}
	public samp_class(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		
		if(id <= 0) 
		throw new IllegalArgumentException("id can't be either 0 or negative");
		
		this.id = id;
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
