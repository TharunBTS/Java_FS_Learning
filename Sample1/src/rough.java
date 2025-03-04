import java.util.*;
import java.util.stream.Collectors;
class Emp2
{
	private int id;
	private String name;
	private int age;
	private String gender;
	private String profession;
	private int yoj;
	private double salary;
	
	public Emp2()
	{
		
	}
	


	public Emp2(int id, String name, int age, String gender, String profession, int yoj, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.profession = profession;
		this.yoj = yoj;
		this.salary = salary;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getYoj() {
		return yoj;
	}
	public void setYoj(int yoj) {
		this.yoj = yoj;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", yoj=" + yoj
				+ ", salary=" + salary + "]";
	}
	
	
}

public class rough
{
	// count of male and female employees
	
	public static void getCount(List<Emp2> el)
	{
		Map<String,Long> l = el.stream()
				.collect(Collectors.groupingBy(Emp2 :: getGender, Collectors.counting()));
		System.out.println(l);
	}
	
	//write a program to print the name of all dep
	
	public static void printDep(List<Emp2> el)
	{
		el.stream()
		.map(Emp2 :: getProfession)
		.distinct()
		.forEach(x -> System.out.println(x));
	}
	
	// avg age of male and female
	public static void avgAge(List<Emp2> el)
	{
		Map<String, Double> e1 = el.stream()
		.collect(Collectors.groupingBy(Emp2 :: getGender, Collectors.averagingInt(Emp2 :: getAge)));
		System.out.println(e1);
	}
	
	//name of emp who joined after 2010
	public static void joinedYear(List<Emp2> el)
	{
		el.stream()
		.filter(x -> x.getYoj() >= 2015)
		.forEach(c -> System.out.println(c.getName()));;
//		System.out.println(e1);
	}
	
	// count no of emp from each dept
	public static void empFromEachDep(List<Emp2> el)
	{
		Map<String, Long> e2 = el.stream()
		.collect(Collectors.groupingBy(Emp2 :: getProfession, Collectors.counting()));
		System.out.println(e2);
	}
	
	// avg sal from each dep
		public static void avgSal(List<Emp2> el)
		{
			Map<String, Double> e2 = el.stream()
			.collect(Collectors.groupingBy(Emp2 :: getProfession, Collectors.averagingDouble(Emp2 :: getSalary)));
			System.out.println(e2);
		}
		
		// max from from employees
		public static void maxAge(List<Emp2> el)
		{
			Optional<Emp2> oe = el.stream().max(Comparator.comparing(Emp2 :: getAge));
			Emp2 emp2 = oe.get();
			System.out.println(emp2.getName()+" "+emp2.getAge());
		}
		
		// find out avg and total sal of comapany
		public static void totSal(List<Emp2> el)
		{
			DoubleSummaryStatistics eSal = el.stream()
					.collect(Collectors.summarizingDouble(Emp2 :: getSalary));
			System.out.println(eSal.getAverage());
			System.out.println(eSal.getSum());
		}
		
		// list emp from each dep
		public static void listEmp(List<Emp2> el)
		{
			Map<String,List<Emp2>> eld = el.stream()
			.collect(Collectors.groupingBy(Emp2 :: getProfession));
			
			for(String s : eld.keySet())
			{
				System.out.print(s+" ---> ");
				List<Emp2> in = eld.get(s);
				for (Emp2 emp2 : in) {
					System.out.print(emp2.getName()+", ");
				}
				System.out.println();
				}
		}
		
		// find out the highest exp
		public static void highestEmp(List<Emp2> el)
		{
//			Optional<Emp2> oe = el.stream().min(Comparator.comparing(Emp2 :: getYoj));
			Optional<Emp2> oe = el.stream().sorted(Comparator.comparing(Emp2 :: getYoj)).findFirst();
			Emp2 emp2 = oe.get();
			
//			emp2.forEach(emp2 -> System.out.println(emp2.getName()+" "+emp2.getAge()));
			System.out.println(emp2);
		}
	
	public static void main(String args[])
	{
		List<Emp2> li = new ArrayList<Emp2>();
		li.add(new Emp2(111,"Jiya",32,"female","HR",2011,25000.0));
		li.add(new Emp2(102,"paul",25,"male","sales",2015,15000.0));
		li.add(new Emp2(113,"martin",29,"male","infra",2014,13500.0));
		li.add(new Emp2(194,"murali",28,"male","product",2010,27000.0));
		li.add(new Emp2(194,"murali",28,"male","product",2010,27000.0));

		li.add(new Emp2(165,"nima",43,"female","account",2015,21000.0));
		li.add(new Emp2(206,"manu",32,"female","sales",2017,35700.0));
		li.add(new Emp2(157,"iqbal",25,"male","product",2012,18000.0));
		li.add(new Emp2(288,"ali",24,"male","product",2011,17000.0));
		System.out.println("Question 1");
		rough.getCount(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 2");
		rough.printDep(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 3");
		rough.avgAge(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 4");
		rough.joinedYear(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 5");
		rough.empFromEachDep(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 6");
		rough.avgSal(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 7");
		rough.maxAge(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 8");
		rough.totSal(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 9");
		rough.listEmp(li);
		System.out.println("--------------------------");
		
		System.out.println("Question 10");
		rough.highestEmp(li);
		System.out.println("--------------------------");
		
	}
}
/*
 * find out the highest orders in a year
 * find out category wise orders count
 * print max price from orders
 * month wise avg spending details
 * find out min order price from total orders
 * first and last product purchased
 * 
 * */
 