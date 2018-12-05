package com.fdmgroup.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.type.LocalDateTimeType;

import com.fdmgroup.dao.TradeDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;

public class BuyServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stockid = request.getParameter("stockid");
		String quantity = request.getParameter("quantity");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedInUser");
		
		int stockidint = Integer.parseInt(stockid);
		double quantityint = Integer.parseInt(quantity);
		TradeDao tdao = new TradeDao();
		
		Trade t = new Trade(stockidint,user.getId(),quantityint,LocalDateTime.now());
		tdao.create(t);
		
		List<Trade> trades = tdao.getTradeByUserid(user.getId());
		session.setAttribute("tradeHistory",trades);
		
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}

}
