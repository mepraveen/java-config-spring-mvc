package com.praveen.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.praveen.model.SignUp;


@Component
public class StudentNotificationSender {

	@Autowired
	private EmailSender emailSender;

	
	
	public void sendStudentNotification(SignUp signUp) {
		
		final String SUBJECT = "Welcome to Praveen App";
        Map<String, String> model = new HashMap<String, String>();
        model.put("subject", SUBJECT);
        model.put("receiver","Hi this is new message from my website..cheers.");
        model.put("message","five little monkey jumping on the bed one feel down and broke his head.mama call the docor and doctor said no more monkey jumping on bed");
        final String TEMPLATE_NAME = "template/welcome.vm";
		EmailMessage emailMessage = new EmailMessage(signUp.getEmail(), "admin", SUBJECT,model,TEMPLATE_NAME);
		System.out.println("EMail :: "+signUp.getEmail());
		this.emailSender.sendMessage(emailMessage);

	}

}
