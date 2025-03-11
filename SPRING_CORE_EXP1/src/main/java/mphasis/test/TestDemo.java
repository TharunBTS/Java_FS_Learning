package mphasis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDemo {
	
	public static void main(String args[])
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(EmpConfig.class);
		Employee obj = (Employee) ctx.getBean("getEmp2");
		System.out.println(obj);
		
	}
}
