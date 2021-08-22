package com.aditya.dataprovider.service;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.aditya.dataprovider.controller.UserController;

public class CommonSchedulers {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void runSchedular() {
	    logger.info("Current time is :: " + Calendar.getInstance().getTime());
	}

}
