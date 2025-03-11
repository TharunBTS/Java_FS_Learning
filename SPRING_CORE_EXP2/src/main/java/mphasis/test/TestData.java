package mphasis.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestData {
	
	@Bean
	public static Student getStudent1()
	{
		return new Student();
	}

	@Bean
	public static Student getStudent2()
	{
		List<String> l = new ArrayList();
		l.add("alex");
		l.add("xander");
		l.add("julius");
		return new Student(2, "ram", l);
	}
}
