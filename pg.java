import java.util.*;
public class prg1 {
	
	public static void main(String args[])
	{
		Scanner ip = new Scanner(System.in);
		int n = ip.nextInt();
		for(int i=0;i<=10;i++)
		{
			if(i % 2 == 0)
			System.out.println(i);
		}
		int val = 0;
		while(val <= 10)
		{
			if(val % 2 != 0) System.out.println(val);
			val++;
		}
		
		if(n % 2 == 0) System.out.println("even");
		else System.out.println("odd");
		
	}
}
