package com.praveen.messaging;

import java.util.Map;

import org.springframework.stereotype.Component;


public class EmailMessage {

	private String to;
	private String from;
	private String subject;
	private Map model;
	private String templatFileName;

	public EmailMessage(String to, String from, String subject,Map model,String templateName) {
		super();
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.model = model;
		this.templatFileName = templateName;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Map getModel() {
		return model;
	}

	public void setModel(Map model) {
		this.model = model;
	}

	public String getTemplatFileName() {
		return templatFileName;
	}

	public void setTemplatFileName(String templatFileName) {
		this.templatFileName = templatFileName;
	}

}
