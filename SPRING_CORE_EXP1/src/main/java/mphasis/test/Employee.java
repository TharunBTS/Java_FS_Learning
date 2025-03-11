package mphasis.test;

public class Employee {
	
	private int id;
	private String name;
	private String cmp;
	private String city;
	private Address aobj;
	public Employee()
	{
		
	}
	
	public Employee(int id, String name, String cmp, String city,Address aobj) {
		this.id = id;
		this.name = name;
		this.cmp = cmp;
		this.city = city;
		this.aobj = aobj;
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
	public String getCmp() {
		return cmp;
	}
	public void setCmp(String cmp) {
		this.cmp = cmp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public Address getAobj() {
		return aobj;
	}

	public void setAobj(Address aobj) {
		this.aobj = aobj;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cmp=" + cmp + ", city=" + city +", aobj=" + aobj + "]";
	}
	
	
	
	
}
