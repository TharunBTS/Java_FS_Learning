package mphasis.test;

//import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	
	 Calculator obj;
	
	static int x;
	static int y;
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.print("BEFORE ALL TEST CASES");
		x = 10;
		y = 50;
	}
	
	@AfterClass
	public static void afterClass()
	{
		System.out.print("AFTER ALL TEST CASES");
		x = 0;
		y = 0;
	}
	
	@Before
	public   void setUp()
	{
		System.out.println("executes every test method before executing");
		obj = new Calculator();
	}
	
	@After
	public  void setDown()
	{
		System.out.println("executes every test method after executing");
		obj = null;
	}
	
	@Test
	public void testAdd()
	{
		System.out.println("testAdd method");
		int res1 = obj.add(x, y);
		assertEquals(60, res1);
	}
	@Test
	public void testSub()
	{
		System.out.println("testSub method");
		int res1 = obj.sub(x, y);
		assertEquals(-40, res1);
	}
	@Test
	public void testMul()
	{
		System.out.println("testMul method");
		int res1 = obj.mul(x, y);
		assertEquals(500, res1);
	}
	@Test
	public void testDiv()
	{
		System.out.println("testDiv method");
		double res1 = obj.div(x, y);
		assertEquals(0.2, res1);
	}
	
	@Test
	public void testGreetuser()
	{
		System.out.println("testGreetuser method");
		assertEquals("Takemitchi", obj.greetUser("Takemitchi"));
	}

}
