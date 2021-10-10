package com.aditya.dataprovider.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

	public void sendHTMLEmail() throws MessagingException {
		mailImplementation.sendHTMLEmail();
	}

	public void sendHTMLEmailWithAttachment() throws MessagingException {
		mailImplementation.sendHTMLEmailWithAttachment();
	}

	public void sendHTMLEmailWithInlineImage(Mail mail) throws MessagingException {
		mailImplementation.sendHTMLEmailWithInlineImage(mail);
	}

}
