package com.aditya.dataprovider.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.aditya.dataprovider.controller.UserController;
import com.aditya.dataprovider.model.User;

//@Component
// Uncomment above annotation to run the scheduler.
// Current job - Inserts hardcoded users to user table.
public class CommonSchedulers {
	
	@Autowired
	UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void runSchedular() {
		User user = new User(99,"Scheduler", "Scheduler", "Scheduler", "Scheduler", "Scheduler");
	    logger.info("Current time is :: " + Calendar.getInstance().getTime());
	    userService.addUser(user);
	}

}
