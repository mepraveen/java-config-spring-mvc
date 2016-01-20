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
import com.praveen.model.LogIn;

@Controller
public class logInController {

	@Autowired
	private SignUpManager signUpManager;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView signIn(@Valid @ModelAttribute("login1") LogIn logIn,
			BindingResult result) {

		if (result.hasErrors()) {
			ModelAndView model = new ModelAndView("login");
			return model;
		} else {

			if (this.signUpManager.findValidation(logIn).size() != 0) {

				ModelAndView model = new ModelAndView("index");

				return model;
			} else {

				ModelAndView model = new ModelAndView("login");
				return model;
			}

		}

	}

}
