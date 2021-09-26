package com.aditya.dataprovider.controller;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.dataprovider.model.User;
import com.aditya.dataprovider.repository.UserRepository;
import com.aditya.dataprovider.service.UserService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) Integer userId) {
		logger.debug("This is a debug message");
		logger.info("This is an info message");
		logger.warn("This is a warn message");
		logger.error("This is an error message");
		return userService.getAllUsers(userId);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody() User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/getCurrentUser")
	public ResponseEntity<String> getCurrentUser(Model model) {
		String currentUserName = userService.getCurrentUser();
		model.addAttribute("name", currentUserName);
		if ( currentUserName.length() > 0 && currentUserName != "Error" )
			return new ResponseEntity<>(currentUserName,HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
