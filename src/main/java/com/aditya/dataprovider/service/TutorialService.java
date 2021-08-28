package com.aditya.dataprovider.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aditya.dataprovider.model.Tutorial;
import com.aditya.dataprovider.repository.TutorialRepository;

@Component
public class TutorialService {

	Logger logger = LoggerFactory.getLogger(TutorialService.class);

	@Autowired
	TutorialRepository tutorialRepository;

	public List<Tutorial> getAllRawTutorials(String title) {
		
		logger.debug("Inside TutorialService raw method");

		List<Tutorial> tutorials = new ArrayList<Tutorial>();

		if (title == null || title.isEmpty())
			tutorialRepository.findAll().forEach(tutorials::add);
		else
			tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

		return tutorials;

	}

}
