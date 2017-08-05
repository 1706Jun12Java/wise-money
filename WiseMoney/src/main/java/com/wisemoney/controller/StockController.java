package com.wisemoney.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
//	@RequestMapping(value="/test")
//	@ResponseBody
//	public String showLoginPage( ) {
////		model.put("name", "wisemoney");
//		return "welcome";
//		
//	}
	
//	@RequestMapping("/add")
//	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
//		int i = Integer.parseInt(request.getParameter("t1"));
//		int j = Integer.parseInt(request.getParameter("t2"));
//		int k = i + j;
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("display.jsp");
//		mv.addObject("result", k);
//		
//		return mv;
//		
//	}
//	@RequestMapping(value="/profile")
//	public List<Stock> showStockList(HttpSession session, HttpServletRequest req){
//		StockDao sd = new StockDaoImpl();
//		session = req.getSession();
//		List<Stock> stockList = sd.getStockList();
//		session.setAttribute("stockList", stockList);
//		return stockList;
//		
//	}
	
	@RequestMapping(value="WiseMoney/profileInfo", method=RequestMethod.GET)
	public List<Stock> showStockLists(HttpSession session) {
		StockDao sd = new StockDaoImpl();
//		User user = (User) session.getAttribute("user");		
//		session.setAttribute("userData", user);
//		
		List<Stock> stockList = sd.getStockList();
		return stockList;
	}
//	@ResponseBody
//	@RequestMapping(value="/profile", method=RequestMethod.GET, produces="application/json")
//	public String showStockList() {
//		return "testing";
//	}
	
	
//	@RequestMapping("/add")
//	public ModelAndView showStocks(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("display");
//		StockDao sd = new StockDaoImpl();
//		
//		List<Stock> stock = sd.getStockList();
//		
////		for (Stock s: sd.getStockList()) {
//			mv.addObject("result", stock);
////		}
//		
//		return mv;
//	}

}
