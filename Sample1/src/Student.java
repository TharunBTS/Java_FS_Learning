import java.util.*;



//class Stu {
//	private int id;
//	private String name;
//	private int age;
//	public Stu()
//	{
//		
//	}
//	public Stu(int id,String name,int age)
//	{
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "Stu [id=" + id + ", name=" + name + ", age=" + age + "]";
//	}
//	
//}

public class Student
{
	public static void main(String args[])
	{
//		List<Stu> sl = new ArrayList<>();
//		sl.add(new Stu(5,"ram",21));
//		sl.add(new Stu(9,"rock",20));
//		sl.add(new Stu(1,"beckham",23));
//		sl.add(new Stu(77,"neymar",37));
		
		List<Integer> li = new ArrayList<>();
		li.add(5);
		li.add(4);
		li.add(3);
		li.add(2);
		li.stream().sorted(Comparator.comparing(Integer :: intValue).reversed()).forEach(c -> System.out.println(c));
		
	}
}