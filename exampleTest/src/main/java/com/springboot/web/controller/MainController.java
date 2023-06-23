package com.springboot.web.controller;

import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController
public class MainController {
	
	@RequestMapping("/")
	public String home() {
		System.out.println("Home Page");
		return "home";
	}

}
