package com.aditya.dataprovider.service;

import com.aditya.dataprovider.model.Tutorial;
import com.aditya.dataprovider.repository.TutorialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class TutorialService {

	Logger logger = LoggerFactory.getLogger(TutorialService.class);

	@Autowired
	TutorialRepository tutorialRepository;

	public List<Tutorial> getAllRawTutorials(String title) {
		
		logger.debug("Inside TutorialService raw method");

		List<Tutorial> tutorials = new ArrayList<>();

		if (ObjectUtils.isEmpty(title))
			tutorials.addAll(tutorialRepository.findAll());
		else
			tutorials.addAll(tutorialRepository.findByTitleContaining(title));

		return tutorials;

	}

}
