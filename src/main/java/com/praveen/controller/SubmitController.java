package com.praveen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.praveen.api.SignUpManager;
import com.praveen.model.SignUp;
import com.praveen.service.SignUpImpl;


@Controller
public class SubmitController {
	
	@Autowired
	private SignUpManager signUpManager;
	
	
	
	
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public ModelAndView getFormSubmited(@Valid @ModelAttribute("signup1") SignUp signup, BindingResult result) {
	
		if(result.hasErrors()){
		
			ModelAndView model = new ModelAndView("signup");
			System.out.println("error");
			return model;
		}
		else{
			

		ModelAndView model = new ModelAndView("submit");
		signUpManager.addNew(signup);
		return model;
		}
	}

}
