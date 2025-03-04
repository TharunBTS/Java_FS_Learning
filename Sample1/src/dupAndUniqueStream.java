import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class dupAndUniqueStream {
	
	public static void main(String args[])
	{
		List<String> list1 = new ArrayList<>();
		list1.add("karan");
		list1.add("karan");
		list1.add("zoro");
		
		Stream<String> l = list1.stream()
		.distinct();
		System.out.println(l);
		}
}
