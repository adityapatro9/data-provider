package com.aditya.dataprovider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aditya.dataprovider.model.Tutorial;
import com.aditya.dataprovider.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserId(int userId);
	
	List<User> findByUserIdContaining(int title);

}
