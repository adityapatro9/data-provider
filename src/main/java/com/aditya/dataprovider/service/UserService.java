package com.aditya.dataprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.aditya.dataprovider.model.User;
import com.aditya.dataprovider.repository.UserRepository;

@Component
public class UserService {
	@Autowired
	UserRepository userRepository;
	
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
	
//	public List<User> generateUser() {
//		List<User> user = new ArrayList<>();
//		user.add(new User(fname.toUpperCase(),lname.toUpperCase(),profession.toUpperCase(),"+91-".concat(phone),email.toLowerCase()));
//		return user;
//	}
	
	public ResponseEntity<List<User>> getAllUsers(Integer userId) {
		try {
			List<User> users = new ArrayList<User>();

			if (userId == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByUserIdContaining(userId).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<User> addUser(User user) {
		try {
			User _user = userRepository.save(new User(user.getUserId(), user.getFirstName(), user.getLastName(),
					user.getProfession(), user.getContactNo(), user.getEmailId()));
			return new ResponseEntity<>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public String getCurrentUser() {
		try {
			List<User> users = new ArrayList<User>();
			userRepository.findAll().forEach(users::add);
			User user = new User(1,fname,lname,profession,phone,email);
			if ( users.contains(user) ) {
				return fname;
			} else {
				return "Guest";
			}
		} catch(Exception e) {
			return "Error";
		}
	}
	
	public List<User> getAllRawUsers(Integer userId) {
		
			List<User> users = new ArrayList<User>();

			if (userId == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByUserIdContaining(userId).forEach(users::add);

			return users;

	}
	
	public List<User> getUserByContactNumber(String contactNo) {
		return userRepository.findByContactNumber(contactNo);
	}
	
	
	
	

}
