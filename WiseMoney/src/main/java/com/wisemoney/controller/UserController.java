package com.wisemoney.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	public String getLogout(HttpSession session, HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		session = req.getSession(false);
		session.invalidate();
		Cookie UIDCookie = new Cookie("JSESSIONID", "");
		UIDCookie.setMaxAge(0);
		UIDCookie.setPath("/");
		resp.addCookie(UIDCookie);
		
		return "redirect:login";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String showUserProfilePage(HttpSession session, HttpServletRequest req) {
		session = req.getSession(false);
		if((session.getAttribute("user")!=null)) {
			return "profile";	
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value="/stockForm", method=RequestMethod.POST)
	public String updatePortfolio(HttpSession session, HttpServletRequest req) {
		String stockSymbol = req.getParameter("stockSymbol");
		String volumeString = req.getParameter("volume");
		int volume = Integer.parseInt(volumeString);
		String lastTx = req.getParameter("lastTx");
		
		User user = (User) session.getAttribute("user");
		StockDao sd = new StockDaoImpl();
		Stock stock = (Stock) sd.getStockBySymbol(stockSymbol);
				
		PortfolioDao pd = new PortfolioDaoImpl();
		
		if (lastTx.equals("BUY")) {
			pd.buyUserStockShares(user, stock, volume);
		} else if (lastTx.equals("SELL")) {
			pd.sellUserStockShares(user, stock, volume);
		} else {
			System.out.println(lastTx);
		}
		
		return "redirect:profile";
	}
	
}
