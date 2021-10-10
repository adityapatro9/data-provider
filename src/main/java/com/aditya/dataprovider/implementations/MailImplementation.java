package com.aditya.dataprovider.implementations;

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

import com.aditya.dataprovider.interfaces.Mail;

@Component
public class MailImplementation implements Mail {

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.from}")
	private String from;

	@Value("${spring.mail.to}")
	private String to;

	@Override
	public void sendPlainTextEmail(com.aditya.dataprovider.model.Mail mail) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getBody());

		mailSender.send(message);

	}

	@Override
	public void sendHTMLEmail(com.aditya.dataprovider.model.Mail mail) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());

		boolean html = true;
		helper.setText(
				"<b>Hey Reader,</b>,<br><i>"+ mail.getSubject() +".</i>",
				html);

		mailSender.send(message);

	}

	@Override
	public void sendHTMLEmailWithAttachment(com.aditya.dataprovider.model.Mail mail) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());

		helper.setText(
				"<b>Dear friend,</b>,<br><i>"+mail.getBody()+"</i>",
				true);

		FileSystemResource file = new FileSystemResource(new File("D:\\resources\\anim_en.pdf"));
		helper.addAttachment("roadmap.pdf", file);

		mailSender.send(message);

	}

	@Override
	public void sendHTMLEmailWithInlineImage(com.aditya.dataprovider.model.Mail mail) throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(mail.getSubject());
		helper.setFrom(from);
		helper.setTo(mail.getTo());

		String content = "<b>Dear friend</b>,<br><i>"+mail.getBody()+"</i>"
				+ "<br><img src='cid:image001'/><br><b>Best Regards</b><br><i>Java Mail</i>";
		helper.setText(content, true);

		FileSystemResource resource = new FileSystemResource(new File("D:\\resources\\" + mail.getImage() + ".jpg"));
		helper.addInline("image001", resource);

		mailSender.send(message);

	}

}
