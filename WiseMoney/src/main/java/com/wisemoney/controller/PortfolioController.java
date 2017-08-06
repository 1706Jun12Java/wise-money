package com.wisemoney.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
	@RequestMapping(value="/portfolio", method=RequestMethod.GET)
	public List<Portfolio> showUserPortfolio(HttpSession session) {
		User user = (User) session.getAttribute("user");	
		PortfolioDao pd = new PortfolioDaoImpl();
		List<Portfolio> portfolio = pd.getUserAllStocks(user);

		return portfolio;
	}

}
