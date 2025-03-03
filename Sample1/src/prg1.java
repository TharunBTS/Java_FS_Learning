import java.util.*;

class pg1
{
	int id;
	String name;
	pg1()
	{
		this .id = 12;
		this.name = "ram";
	}
}

class prg1
{
	public static void main(String args[])
	{
//		Scanner ip = new Scanner(System.in);
		pg1 p = new pg1();
		pg1 p2 = p;
		p.name = "kumar";
		System.out.println(p.name);
		System.out.println(p2.name);
		
	}
}