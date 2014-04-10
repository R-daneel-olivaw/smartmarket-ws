/**
 * This file is part of SmartMarket.
 *
 * SmartMarket is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * SmartMarket is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SmartMarket.  If not, see <http://www.gnu.org/licenses/>.
 */

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
