package com.aditya.dataprovider.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailService {
	
	@Value( "${spring.mail.from}" )
	private String from;
	
	@Value( "${spring.mail.to}" )
	private String to;
	
	@Autowired
	private JavaMailSender mailSender;

	public void sendPlainTextEmail () {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject("New Update");
		message.setText("Hello Reader! Implemented Spring mail! Take a master pull! Good Day ahead!");
		
		mailSender.send(message);
	}
	
	public void sendHTMLEmail () throws MessagingException {
	
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setSubject("Ongoing Update");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText("<b>Hey Reader,</b>,<br><i>Spring Batch work in progress. Taking time to understand and implement.</i>", html);

		mailSender.send(message);
	}
	
	public void sendHTMLEmailWithAttachment () throws MessagingException {
	
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("Anime/Manga Map Japan");
		helper.setFrom(from);
		helper.setTo(to);
		
		helper.setText("<b>Dear friend,</b>,<br><i>Please find stores and map for anime and manga shopping attached.</i>", true);
		
		FileSystemResource file = new FileSystemResource(new File("D:\\resources\\anim_en.pdf"));
		helper.addAttachment("roadmap.pdf", file);

		mailSender.send(message);

	}
	
	public void sendHTMLEmailWithInlineImage () throws MessagingException {
		
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject("My Recent Ongoing Anime");
		helper.setFrom(from);
		helper.setTo(to);
		
		String content = "<b>Dear friend</b>,<br><i>I am recently watching a cool Anime, The Seven Deadly Sins.</i>"
							+ "<br><img src='cid:image001'/><br><b>Best Regards</b>"; 
		helper.setText(content, true);
		
		FileSystemResource resource = new FileSystemResource(new File("D:\\resources\\sevensins.jpg"));
		helper.addInline("image001", resource);

		mailSender.send(message);
			
	}

}
