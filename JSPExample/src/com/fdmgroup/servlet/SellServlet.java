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

import com.fdmgroup.dao.TradeDao;
import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;

public class SellServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sell");
		
		String stockid = request.getParameter("stockid2");
		String quantity = request.getParameter("quantity2");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loggedInUser");
		
		
		int stockidint = Integer.parseInt(stockid);
		double quantityint = Integer.parseInt(quantity);
		TradeDao tdao = new TradeDao();
		
		Trade t = new Trade(stockidint,user.getId(),-quantityint,LocalDateTime.now());
		tdao.create(t);
		
		List<Trade> trades = tdao.getTradeByUserid(user.getId());
		session.setAttribute("tradeHistory",trades);
		RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}

}
