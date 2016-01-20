package com.praveen.messaging;

import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Component
public class EmailSender {

	@Autowired
	private EmailProperty property;

	@Autowired
	private VelocityEngine velocityEngine;

	@Async
	public void sendMessage(EmailMessage msg) {
		try {
			System.out.println("inside end email");
			Session session = Session.getInstance(this.getEmailProperty(),
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(property
									.getUsername(), property.getPassword());
													}
					});
			Transport.send(this.getMessage(session, msg));
		} catch (Exception ex) {
			System.out.println("EMAIL ERROR :" + ex.getMessage());
		}

	}

	private javax.mail.Message getMessage(Session session, EmailMessage msg) {
		MimeMessage message = new MimeMessage(session);
		try {
			
			System.out.println("username ::"+property.getUsername()+"password ::::"+property.getPassword()+"host ::"+property.getPort());
			Multipart multipart = new MimeMultipart();
			BodyPart messageBodyPart = new MimeBodyPart();
			String messageBody = "";

			message.setSentDate(new Date());

			message.setFrom(new InternetAddress(property.getUsername()));
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(msg.getTo()));
			System.out.println(">>>>>>>>>>"+msg.getTo());
			message.setSubject(msg.getSubject());
			messageBody = VelocityEngineUtils.mergeTemplateIntoString(
					velocityEngine, msg.getTemplatFileName(), "UTF-8",
					msg.getModel());
			messageBodyPart.setContent(messageBody, "text/html");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);

		} catch (MessagingException ex) {
			System.out.println("EMAIL ERROR :" + ex.getMessage());
		}
		return message;
	}

	private Properties getEmailProperty() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", this.property.isAuthentication());
		props.put("mail.smtp.starttls.enable", this.property.isEnableSSL());
		props.put("mail.smtp.host", this.property.getHost());
		props.put("mail.smtp.port", this.property.getPort());
		return props;
	}
}
