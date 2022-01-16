package com.aditya.dataprovider.controller;

import com.aditya.dataprovider.model.UserAuth;
import com.aditya.dataprovider.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/userAuth")
public class UserAuthController {

    @Autowired
    UserAuthService userAuthService;

    @GetMapping("getUserById/{id}")
    public ResponseEntity<UserAuth> getUserById(@PathVariable("id") Long id) {
        UserAuth userAuth = userAuthService.getUserById(id);
        if (!ObjectUtils.isEmpty(userAuth))
            return new ResponseEntity<>(userAuth,HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getUserByContactNo/{contactNo}")
    public ResponseEntity<UserAuth> getUserByContactNo(@PathVariable("contactNo") String contactNo) {
        UserAuth userAuth = userAuthService.getUserByContactNo(contactNo);
        if (!ObjectUtils.isEmpty(userAuth))
            return new ResponseEntity<>(userAuth,HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("getUserByEmailId/{emailId}")
    public ResponseEntity<UserAuth> getUserByEmailId(@PathVariable("emailId") String emailId) {
        UserAuth userAuth = userAuthService.getUserByEmailId(emailId);
        if (!ObjectUtils.isEmpty(userAuth))
            return new ResponseEntity<>(userAuth,HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
