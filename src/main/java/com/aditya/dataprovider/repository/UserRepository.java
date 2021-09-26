package com.aditya.dataprovider.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aditya.dataprovider.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByUserId(int userId);
	
	List<User> findByUserIdContaining(int title);
	
	@Query(value ="SELECT * FROM users WHERE contact_no = ?1", nativeQuery = true)
	List<User> findByContactNumber(String contactNo);

}
