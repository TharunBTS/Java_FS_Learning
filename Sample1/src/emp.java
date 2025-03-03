import java.util.*;
import java.util.stream.Collectors;

class samp 
{
	private int id;
	private String name;
	private int age;
	private String gender;
	private int year;
	
	samp()
	{
		
	}
	samp(int id, String name,int age,String gender,int year)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.year = year;
	}

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	

	public int getAge() {
		return age;
	}

	

	public String getGender() {
		return gender;
	}

	

	public int getYear() {
		return year;
	}
	@Override
	public String toString() {
		return "samp [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", year=" + year + "]";
	}

	
	
}
// iterate using stream api and print starts with anyone char
//iterate using stream api and print who joined after 2020
// joind in 2020 and in any sorted manner 
// store it in the new list

public class emp {
	public static void main(String args[]) {
	List<samp> li = new ArrayList<>();
	li.add(new samp(1,"ram",21,",male",2021));
	li.add(new samp(9,"hema",18,",female",2019));
	li.add(new samp(2,"hrithik",20,",male",2025));
	li.add(new samp(7,"jansi",23,",female",2030));
	
	li.add(new samp(11,"rambo",37,",male",2020));
	li.add(new samp(31,"susuka",18,",female",2019));
	li.add(new samp(27,"hrithik",29,",male",2030));
	li.add(new samp(60,"jennifer",23,",female",2018));
	
	
	System.out.println("starts with");
	li.stream().filter(c -> c.getName().startsWith("h")).forEach(val -> System.out.println(val.getName()));;
	System.out.println("----------------------------");
	System.out.println("joined >= 2020");
	li.stream().filter(c -> c.getYear() >= 2020).forEach(val -> System.out.println(val.getName()+" - "+val.getYear()));;
	System.out.println("----------------------------");
	System.out.println("joined after 2020 and sorted using name and age and added to new List");
	List<samp> res= li.stream()
			.filter(c -> c.getYear() > 2020)
			.sorted(Comparator.comparing(samp :: getName)
			.thenComparing(samp :: getAge).reversed())
			.collect(Collectors.toList());
	System.out.println(res);
	}
}
