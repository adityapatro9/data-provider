package com.aditya.dataprovider.controller;

import com.aditya.dataprovider.model.Tutorial;
import com.aditya.dataprovider.model.User;
import com.aditya.dataprovider.service.TutorialService;
import com.aditya.dataprovider.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TutorialService tutorialService;
	
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
		logger.info("Service: Fetching user with name {}", name);
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
	
	@GetMapping("/allTutorials")
	public String showAllTutorials(Model model) {
		List<Tutorial> tutorials = new ArrayList<>();
		tutorials = tutorialService.getAllRawTutorials("");
		model.addAttribute("tutorials", tutorials);
		logger.info("Entered all Tutorials!!!");
		return "allTutorials";
		
	}

	@GetMapping("/searchUser")
	public String getUserByContactNumber(@RequestParam(name="contactNo")String contactNo, Model model) {
		List<User> user = userService.getUserByContactNumber(contactNo);
		model.addAttribute("users", user);
		logger.info("Entered searchUser!!!");
		return "searchUserResult";
	}

	@GetMapping("/showSearchUserForm")
	public String showSearchUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "searchUser";
	}
}
