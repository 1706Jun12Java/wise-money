package com.wisemoney.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wisemoney.dao.PortfolioDao;
import com.wisemoney.dao.PortfolioDaoImpl;
import com.wisemoney.dao.StockDao;
import com.wisemoney.dao.StockDaoImpl;
import com.wisemoney.dao.UserDao;
import com.wisemoney.dao.UserDaoImpl;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;

@Controller
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationPage() {
		LOGGER.debug("In register page");
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String saveUser(HttpServletRequest req, HttpServletResponse resp) {
		
		String username = req.getParameter("username");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		//validation on the provided form data
		UserDao ud = new UserDaoImpl();
		
		if((ud.getUserByUsername(username))!=null) {
			return "register";
		}
		
//		UserDao ud = new UserDaoImpl();
		ud.register(username, firstName, lastName, password, email);
		LOGGER.debug("Go to login page");
		return "redirect:login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginPage(HttpSession session) {
		LOGGER.debug("In login page");
		if((session.getAttribute("user"))==null) {
			return "login";
		} else {
			return "redirect:profile";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(HttpSession session, HttpServletRequest req, HttpServletResponse resp, Model m) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		//validation on login credentials
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
				
		UserDao ud = new UserDaoImpl();
		if (ud.login(username, password)!=null) {
			User user = ud.login(username, password);
			session.setAttribute("user", user);
			LOGGER.debug("Go to profile page");
			return "redirect:profile";
		} else {
			
			LOGGER.debug("Invalid credentials. Return to login page");
			messages.put("password", "Invalid username/password");
			return "login";
		}
		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		session = req.getSession(false);
		session.invalidate();
		Cookie UIDCookie = new Cookie("JSESSIONID", "");
		UIDCookie.setMaxAge(0);
		UIDCookie.setPath("/");
		resp.addCookie(UIDCookie);
		
		LOGGER.debug("Logout");
		return "redirect:login";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String showUserProfilePage(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		if((session.getAttribute("user"))!=null) {
			LOGGER.debug("In profile page");
			return "profile";	
		} else {
			LOGGER.debug("Not signed in yet. Return to login page");
			return "login";
		}
	}
	
	@RequestMapping(value="/stockForm", method=RequestMethod.POST)
	public String updatePortfolio(HttpSession session, HttpServletRequest req) {
		LOGGER.debug("In updatePortfolio method");
		String stockSymbol = req.getParameter("stockSymbol");
		String volumeString = req.getParameter("volume");
		int volume = Integer.parseInt(volumeString);
		String lastTx = req.getParameter("lastTx");

		//validation on volume. You can't buy/sell 0 or negative shares!
		Map<String, String> messages = new HashMap<String, String>();
		req.setAttribute("messages", messages);
		
		if(volume<=0) {
			messages.put("volume", "Invalid number. Please enter a positive number greater than 0");
			return "redirect:profile";
			
		}
		
		User user = (User) session.getAttribute("user");
		StockDao sd = new StockDaoImpl();
		Stock stock = (Stock) sd.getStockBySymbol(stockSymbol);
		
		PortfolioDao pd = new PortfolioDaoImpl();
		
		
		if (lastTx.equals("BUY")) {
			LOGGER.debug("User bought a share(s)");
			pd.buyUserStockShares(user, stock, volume);
		} else if (lastTx.equals("SELL")) {
			LOGGER.debug("User sold a share(s)");
			pd.sellUserStockShares(user, stock, volume);
		}
		//check that he enters only the allowed stock symbols
		
		LOGGER.debug("Return to profile page");
		return "redirect:profile";
	}
	
}
