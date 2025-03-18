package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class PageController {
	
	@RequestMapping("/")
	public String homePage()
	{
		return "home";
	}

}
