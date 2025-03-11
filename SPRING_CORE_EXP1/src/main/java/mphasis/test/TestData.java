package mphasis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestData {

	public static void main(String[] args) {
		
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//		  Employee obj = (Employee) ctx.getBean("emp");  (or)
		 Employee obj = ctx.getBean("emp2",Employee.class);
		 System.out.println(obj);
	}

}
