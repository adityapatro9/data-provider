package com.aditya.dataprovider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.dataprovider.model.User;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {
	@Value( "${user.fname}" )
	private String fname;
	
	@Value( "${user.lname}" )
	private String lname;
	
	@Value( "${user.profession}" )
	private String profession;
	
	@Value( "${user.phone}" )
	private String phone;
	
	@Value( "${user.email}" )
	private String email;
	
	@GetMapping("/details")
	public List<User> getUserDetails() {
		
		List<User> user = new ArrayList<>();
		user.add(new User(fname.toUpperCase(),lname.toUpperCase(),profession.toUpperCase(),"+91-".concat(phone),email.toLowerCase()));
		return user;
	}

}
