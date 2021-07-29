package com.aditya.dataprovider.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
//	@GetMapping("/details")
//	public List<User> getUserDetails() {
//		return userService.generateUser();
//	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) Integer userId) {
		return userService.getAllUsers(userId);
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody() User user) {
		return userService.addUser(user);
	}
	
	

}
