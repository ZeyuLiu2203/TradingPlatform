package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CompanyDao;
import com.fdmgroup.dao.TradeDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;

public class LoginServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserDao udao = new UserDao();
		
		
		if(username.equals("admin") && password.equals("admin")) {
				HttpSession session = request.getSession();
				User tryAdmin = udao.findByUsername(username);
				session.setAttribute("loggedInUser",tryAdmin);
				RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			}
		
			
		else {
			HttpSession session = request.getSession();
			int result = Integer.parseInt(username);
			User foundUser = udao.findById(result);
			CompanyDao cdao = new CompanyDao();
			List<Company> companies = cdao.findAll();
			session.setAttribute("companies", companies);
			if(foundUser!= null && password != null && password.equals(foundUser.getPassword())) {
			
				session.setAttribute("loggedInUser",foundUser);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				TradeDao tdao = new TradeDao();
				List<Trade> trades = tdao.getTradeByUserid(foundUser.getId());
				session.setAttribute("tradeHistory",trades);
				rd.forward(request, response);
				
				
			}else {
				request.setAttribute("error", "Invalid username/password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

}
