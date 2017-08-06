// package com.wisemoney.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.wisemoney.dao.UserDaoImpl;
//
//public class UserController extends HttpServlet{
//
//	/**
//	 * http://www.javawebtutor.com/articles/hibernate/hibernate_web_example.php
//	 * master servlet should be in web.xml
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	protected void doPost(HttpServletRequest request,
//            HttpServletResponse response) throws ServletException, IOException {
// 
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");
// 
//        HttpSession session = request.getSession(true);
//        try {
//            UserDaoImpl userDAO = new UserDaoImpl();
//            userDAO.addNewUser(firstName, lastName, userName, password, email);
//            response.sendRedirect("Success");
//        } catch (Exception e) { 
//            e.printStackTrace();
//        }
// 
//    }
//
//}
