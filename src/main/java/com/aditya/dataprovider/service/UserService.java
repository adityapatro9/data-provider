package com.aditya.dataprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.aditya.dataprovider.model.User;

@Component
public class UserService {
	
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
	
	public List<User> generateUser() {
		List<User> user = new ArrayList<>();
		user.add(new User(fname.toUpperCase(),lname.toUpperCase(),profession.toUpperCase(),"+91-".concat(phone),email.toLowerCase()));
		return user;
	}

}
