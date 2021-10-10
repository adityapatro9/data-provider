package com.aditya.dataprovider.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aditya.dataprovider.model.Mail;
import com.aditya.dataprovider.service.MailService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	MailService mailService;

	@GetMapping("/sendPlainTextEmail")
	public ResponseEntity<String> sendPlainTextEmail(@RequestBody Mail mail) {
		mailService.sendPlainTextEmail(mail);
		return new ResponseEntity<>("Mail Sent to "+ mail.getTo(),HttpStatus.OK);
	}
	
	@GetMapping("/sendHTMLEmailWithInlineImage")
	public ResponseEntity<String> sendHTMLEmailWithInlineImage(@RequestBody Mail mail) throws MessagingException {
		mailService.sendHTMLEmailWithInlineImage(mail);
		return new ResponseEntity<>("Mail Sent to "+ mail.getTo(),HttpStatus.OK);
	}
}
