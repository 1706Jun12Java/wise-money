package com.wisemoney.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wisemoney.domain.User;
import com.wisemoney.dao.UserService;

@Controller
public class RegistrationController {
	/*
	 * https://dzone.com/articles/spring-mvc-example-for-user-registration-and-login-1
	 */
	@Autowired
	public UserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	ModelAndView mav = new ModelAndView("register");
	mav.addObject("user", new User());
	return mav;
	}
	  
	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
	@ModelAttribute("user") User user) {
	userService.register(user);
	return new ModelAndView("welcome", "firstname", user.getFirstName());
	}
}
