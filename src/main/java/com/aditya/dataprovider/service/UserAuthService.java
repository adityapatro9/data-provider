package com.aditya.dataprovider.service;

import com.aditya.dataprovider.model.UserAuth;
import com.aditya.dataprovider.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthService {
     @Autowired
    UserAuthRepository userAuthRepository;

    public UserAuth getUserById(Long userId) {
        return userAuthRepository.findByUserId(userId);
    }

    public UserAuth getUserByContactNo(String contactNo){
        return userAuthRepository.findByContactNumber(contactNo);
    }

    public UserAuth getUserByEmailId(String emailId){
        return userAuthRepository.findByEmailId(emailId);
    }
}
