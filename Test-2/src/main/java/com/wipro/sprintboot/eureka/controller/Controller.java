package com.wipro.sprintboot.eureka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/test")
	public String name()
	{
		return "Healthy 2 !!";
	}

}