package com.praveen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.api.SignUpManager;


@RestController
public class SignUpController {
	
	@Autowired
	private SignUpManager signUpManager;
	
	
	@RequestMapping(value="/check/{username}", method=RequestMethod.GET)
	public String checkUsernameAviability(@PathVariable("username") String username){
		
		if(this.signUpManager.findByUsername(username).size()==0){
			return "true";
		}else{
			return "false";
		}
		
	}
	
	
	
	

}
