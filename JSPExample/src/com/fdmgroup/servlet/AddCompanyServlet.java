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

public class AddCompanyServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String companyname = request.getParameter("companyname");
		String stocksymbol = request.getParameter("stocksymbol");
		String exchangeId = request.getParameter("exchangeid");
		String price = request.getParameter("price");
		
		int exchangeid = Integer.parseInt(exchangeId);
		double d = Double.parseDouble(price);
		
		Company c = new Company(companyname, stocksymbol, exchangeid, d);
		
		CompanyDao cdao = new CompanyDao();
		
		cdao.create(c);
		HttpSession session = request.getSession();
		List<Company> companies = cdao.findAll();
		session.setAttribute("companies", companies);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
		
		
	}

}

