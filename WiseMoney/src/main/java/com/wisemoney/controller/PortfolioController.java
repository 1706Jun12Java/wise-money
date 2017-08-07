package com.wisemoney.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wisemoney.dao.PortfolioDao;
import com.wisemoney.dao.PortfolioDaoImpl;
import com.wisemoney.dao.StockDao;
import com.wisemoney.dao.StockDaoImpl;
import com.wisemoney.domain.Portfolio;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;

@RestController
public class PortfolioController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
		
	@RequestMapping(value="/portfolio", method=RequestMethod.GET)
	public List<Portfolio> showUserPortfolio(HttpSession session) {
		LOGGER.debug("Show the user's portfolio");
		User user = (User) session.getAttribute("user");	
		PortfolioDao pd = new PortfolioDaoImpl();
		List<Portfolio> portfolio = pd.getUserAllStocks(user);

		return portfolio;
	}

}
