package mphasis.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Timeout;

@Timeout(value = 4, unit = TimeUnit.SECONDS)
public class junit1test {
	
	junit1 j;
	
	static String s;
	static int age;
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("beforeClass");
		s = "raghu";
		age = 21;
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.println("afterClass");
		s = "";
		age = 0;
	}
	
	@Before
	public void setUp()
	{
		System.out.println("before");
		j = new junit1();
	}
	
	@After
	public void setDown()
	{
		System.out.println("after");
		j = null;
	}
	
	@Test
	public void nameTest()
	{
		System.out.println("testAdd method");
		String res1 = j.getName(s);
		assertEquals("uhgar", res1);
//		assertEquals("fjkkj", res1);
	}
	@Test
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	public void ageTest()
	{
		try {
			System.out.println("testAdd method");
			int res1 = j.getAge(age);
			assertEquals(21, res1);
			
			TimeUnit.SECONDS.sleep(5);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
