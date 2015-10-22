package com.great.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("organization")

public class HomeController {
	
	@RequestMapping("/hello")
	public String showHello(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "hello";
	}
	@RequestMapping("/")
	public String showIndex(){
		//System.out.println("Spring - Great Web Hello Controller!");
		return "index";
	}
	
	@RequestMapping("/tasks")
	public String showTasks(){
		//System.out.println("Spring - Great Web Index Controller!");
		return "login";
	}
<<<<<<< HEAD
=======

	@RequestMapping("/submission")
	public String showSubmission(){
		System.out.println("Submission Page Mapping");
		return "submission";
	}
	
	@RequestMapping("/projectgroups")
	public String showProjectGroup(){
		System.out.println("Project Group  Page Mapping");
		//return "project-groups";
		return "project-groups";
	}
	
>>>>>>> 2bcdb944386e4161dc233dcc78ca38a9f8b3822b
}
