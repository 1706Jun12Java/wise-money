package com.wisemoney.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wisemoney.dao.UserDao;
import com.wisemoney.dao.UserDaoImpl;
import com.wisemoney.domain.User;

@Controller
public class UserController {
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationPage() {
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String saveUser(HttpServletRequest req, HttpServletResponse resp) {
		
		String username = req.getParameter("username");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		UserDao ud = new UserDaoImpl();
		ud.register(username, firstName, lastName, password, email);
		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model m) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao ud = new UserDaoImpl();
		if (ud.login(username, password)!=null) {
			User user = ud.login(username, password);
			session.setAttribute("user", user);	
			return "redirect:profile";
		} else {
			return "login";
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void logoutUser(HttpSession session, HttpServletRequest req, HttpServletResponse resp) {
		session = req.getSession();
		session.invalidate();
		try {
			resp.sendRedirect("login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String showUserProfilePage(HttpSession session, HttpServletRequest req) {
		User user = (User) session.getAttribute("user");		
		session.setAttribute("userData", user);
		return "profile";
	}
	
}
