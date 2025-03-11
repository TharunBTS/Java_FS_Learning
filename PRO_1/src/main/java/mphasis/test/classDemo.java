package mphasis.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class classDemo {

	public static void main(String[] args) {
		
		ApplicationContext ctx1 = new ClassPathXmlApplicationContext("beans.xml");
		Class obj1 = (Class) ctx1.getBean("obj");
		System.out.println(obj1);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(C1.class);
		Class obj = (Class) ctx.getBean("getClass2");
		System.out.println(obj);
		
		ApplicationContext ctx2 = new AnnotationConfigApplicationContext(C1.class);
		ClasRecord obj3 = (ClasRecord) ctx2.getBean("getrec2");
		System.out.println(obj3);
		
		
	}

}
