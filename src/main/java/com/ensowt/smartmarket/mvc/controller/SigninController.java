package com.ensowt.smartmarket.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("signin")
public class SigninController {

	@RequestMapping("")
	public ModelAndView showSignInPage(ModelAndView modelAndView) {
		
		modelAndView.setViewName("merchantSignin");

		return modelAndView;
	}
}
