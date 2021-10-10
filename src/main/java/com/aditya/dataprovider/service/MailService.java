package com.aditya.dataprovider.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aditya.dataprovider.implementations.MailImplementation;
import com.aditya.dataprovider.model.Mail;

@Component
public class MailService {

	@Autowired
	private MailImplementation mailImplementation;

	public void sendPlainTextEmail(Mail mail) {
		mailImplementation.sendPlainTextEmail(mail);
	}

	public void sendHTMLEmail(Mail mail) throws MessagingException {
		mailImplementation.sendHTMLEmail(mail);
	}

	public void sendHTMLEmailWithAttachment(Mail mail) throws MessagingException {
		mailImplementation.sendHTMLEmailWithAttachment(mail);
	}

	public void sendHTMLEmailWithInlineImage(Mail mail) throws MessagingException {
		mailImplementation.sendHTMLEmailWithInlineImage(mail);
	}

}
