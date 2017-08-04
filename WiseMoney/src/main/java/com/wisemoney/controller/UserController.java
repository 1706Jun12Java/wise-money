package com.wisemoney.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wisemoney.dao.UserDao;
import com.wisemoney.dao.UserDaoImpl;

@Controller
public class UserController {
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String show() {
		return "register";
	}
	
	
//	@RequestMapping(value="/register", method=RequestMethod.GET)
//	public ModelAndView showRegistrationPage(HttpServletRequest request,
//			HttpServletResponse response) {
////		ModelAndView model = new ModelAndView("register");
//		  
//		return new ModelAndView("register", "registerTrader", new User());
//		
//	}
	
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
	public String loginUser(HttpServletRequest req, HttpServletResponse resp) {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		UserDao ud = new UserDaoImpl();
		if ((Integer) ud.login(username, password) instanceof Integer) {
			return "profile";
		} else {
			return "login";
		}
//		ud.register(username, firstName, lastName, password, email);
		
//		return "login";
		
		
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String loginUser(@RequestParam("username") String username,
//						@RequestParam("password") String password,
//						
//			@Valid @ModelAttribute("loginTrader") User user,
//			BindingResult result, ModelMap model) {
//		if (result.hasErrors()) {
//			return "error";
//		}
//		
//		UserDao ud = new UserDaoImpl();
//		if ((ud.login(username, password))==0) {
//			return "login";
//		}
//		else {
//			return "profile";
//		}
//	}
}
