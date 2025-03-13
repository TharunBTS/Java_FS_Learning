package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	@RequestMapping("/homepage")
	public String homePage()
	{
		return "home";
	}
	
	@RequestMapping("/user")
	public String userForm()
	{
		return "userform";
	}

}
