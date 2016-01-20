package com.praveen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value={"/","index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/examples", method=RequestMethod.GET)
	public ModelAndView example() {
		return new ModelAndView("examples");
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public ModelAndView signup() {
		return new ModelAndView("signup");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView lo() {
		return new ModelAndView("login");
	}
	
	
}
