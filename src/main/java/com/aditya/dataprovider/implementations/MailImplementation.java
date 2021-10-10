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
	public void sendHTMLEmail() throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setSubject("Ongoing Update");
		helper.setFrom(from);
		helper.setTo(to);

		boolean html = true;
		helper.setText(
				"<b>Hey Reader,</b>,<br><i>Spring Batch work in progress. Taking time to understand and implement.</i>",
				html);

		mailSender.send(message);

	}

	@Override
	public void sendHTMLEmailWithAttachment() throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject("Anime/Manga Map Japan");
		helper.setFrom(from);
		helper.setTo(to);

		helper.setText(
				"<b>Dear friend,</b>,<br><i>Please find stores and map for anime and manga shopping attached.</i>",
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

		String content = "<b>Dear friend</b>,<br><i>I am recently watching a cool Anime," + " Fairy Tail" + ".</i>"
				+ "<br><i>What are you watching this friday???</i>"
				+ "<br><img src='cid:image001'/><br><b>Best Regards</b><br><i>Java Mail</i>";
		helper.setText(content, true);

		FileSystemResource resource = new FileSystemResource(new File("D:\\resources\\" + mail.getImage() + ".jpg"));
		helper.addInline("image001", resource);

		mailSender.send(message);

	}

}
