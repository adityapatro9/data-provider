package com.aditya.dataprovider.interfaces;

import javax.mail.MessagingException;

public interface Mail {

	public void sendPlainTextEmail(com.aditya.dataprovider.model.Mail mail);

	public void sendHTMLEmail() throws MessagingException;

	public void sendHTMLEmailWithAttachment() throws MessagingException;

	public void sendHTMLEmailWithInlineImage(com.aditya.dataprovider.model.Mail mail) throws MessagingException;
}
