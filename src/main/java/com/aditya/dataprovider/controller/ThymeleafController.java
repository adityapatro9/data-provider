package com.aditya.dataprovider.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aditya.dataprovider.model.User;
import com.aditya.dataprovider.service.UserService;

@Controller
public class ThymeleafController {
	
	@Autowired
	UserService userService;
	
	@Value("${user.fname}")
	private String userName;
	
	Logger logger = LoggerFactory.getLogger(ThymeleafController.class);
	
	
	@GetMapping("/home")
	public String greeting() {	
		return "home";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		name = name.length() > 0 && !name.equals("World")? name : userName;
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/allUsers")
	public String showAllUsers(Model model) {
		List<User> users = new ArrayList<>();
		users = userService.getAllRawUsers(null);
		model.addAttribute("users", users);
		logger.info("Entered all users!!!");
		return "allUsers";
	}

}
