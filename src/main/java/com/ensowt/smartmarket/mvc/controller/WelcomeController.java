package com.ensowt.smartmarket.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
	@RequestMapping("")
	public ModelAndView showWelcomePage(ModelAndView modelAndView) {

		modelAndView.setViewName("welcome");

		return modelAndView;
	}
}
