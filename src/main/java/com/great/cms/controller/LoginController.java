package com.great.cms.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.great.cms.db.entity.Course;
import com.great.cms.db.entity.User;
import com.great.cms.service.TeacherCourseService;
import com.great.cms.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private TeacherCourseService courseService;

	@Autowired
	private UserService userService;
	
	
	private User user=null;
	
	private JSONArray jsonArray;

	@RequestMapping("/checklogin")
	public  String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {

		
     try{
		user = userService.getUserByName(username);
		if (user == null) {
			model.addAttribute("message", "Invalid usrname or password");
			return "login";
		}

		if (user.getPassword().equals(password)) {
			System.out.println("redirect to course");
			return "redirect:/course";
		}	
		

		else {
			model.addAttribute("message", "Invalid usrname or password");
			return "login";
		}
		}
     catch(Exception e){
    	 System.out.println("Exception in "+e);
    	 return "login";
     }
     

	}
	@RequestMapping("/sign-in.html")
	public String logOut(Model model){
		try{
		System.out.println("our current user" +user.getUserName());
		return "login";
		}
		catch(Exception e){
			System.out.println("exception "+e);
			return "login";
		}
		
	}

}
