import java.util.*;    


class Employee implements Comparable<Employee>
{
	private int id;
	private String name;
	public Employee()
	{
		
	}
	public Employee(int id,String name)
	{
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int compareTo(Employee o) {
		return this.id - o.id;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
}

class NameComparator implements Comparator<Employee>
{
	public int compare(Employee o1, Employee o2)
	{
		return o1.getName().compareTo(o2.getName());
	}
}

public class prg1
{
	public static void main(String args[])
	{
//		Employee e = new Employee();
//		Employee e = new Employee(9,"ram");
//		Employee e = new Employee(3,"ram");
		List<Employee> l = new ArrayList<>();
		l.add(new Employee(1,"aam"));
		l.add(new Employee(9,"aghu"));
		l.add(new Employee(3,"ash"));
		l.add(new Employee(5,"gary"));
//		System.out.println(e.getId()+" "+e.getName());
		System.out.println(l);
		Collections.sort(l);
		System.out.println(l);
		
		Collections.sort(l,new NameComparator());
		System.out.println(l);
		
	}
}