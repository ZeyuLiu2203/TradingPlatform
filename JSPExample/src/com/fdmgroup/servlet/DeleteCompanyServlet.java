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

import com.fdmgroup.dao.CompanyDao;
import com.fdmgroup.dao.TradeDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;

public class DeleteCompanyServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stockid = request.getParameter("stockid");
		
		int stockidint = Integer.parseInt(stockid);
		
		CompanyDao cdao = new CompanyDao();
		HttpSession session = request.getSession();
		
		Company c = cdao.findById(stockidint);
		
		cdao.remove(c);
		
		List<Company> companies = cdao.findAll();
		session.setAttribute("companies", companies);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
