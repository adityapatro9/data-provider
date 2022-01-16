package com.aditya.dataprovider.repository;

import com.aditya.dataprovider.model.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

   UserAuth findByUserId(Long userId);

    @Query(value ="SELECT * FROM USER_AUTH WHERE contact_no = ?1", nativeQuery = true)
    UserAuth findByContactNumber(String contactNo);

    @Query(value ="SELECT * FROM USER_AUTH WHERE email_id = ?1", nativeQuery = true)
    UserAuth findByEmailId(String emailId);
}
