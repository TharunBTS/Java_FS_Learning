package mphasis.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class C1 {
	
	@Bean
	public static Class getClass1()
	{
		return new Class();
	}
	
	@Bean
	public static Class getClass2()
	{
		return new Class(1,"sasuke");
	}
	
	@Bean
	public static ClasRecord getrec2()
	{
		List<String> la = Arrays.asList("one-piece","haikyuu","hxh");
		return new ClasRecord(1,"sasuke", la);
	}

	
	
}
