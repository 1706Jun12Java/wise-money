package com.wisemoney.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wisemoney.dao.StockDao;
import com.wisemoney.dao.StockDaoImpl;
import com.wisemoney.domain.Stock;
import com.wisemoney.domain.User;

@RestController
public class StockController {
	
	private static final Logger LOGGER = Logger.getLogger(StockController.class);

	
	@RequestMapping(value="/stocks", method=RequestMethod.GET)
	public List<Stock> showStockLists(HttpSession session) {
		LOGGER.debug("Display stock market data");
		StockDao sd = new StockDaoImpl();
		List<Stock> stockList = sd.getStockList();
		return stockList;
	}	
}
