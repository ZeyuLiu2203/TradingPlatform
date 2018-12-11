package com.fdmgroup.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.TradeDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.Trade;
import com.fdmgroup.model.User;

public class TestFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	
		
		HttpSession session = ((HttpServletRequest) req).getSession();
		User user = (User) session.getAttribute("loggedInUser");
		TradeDao tdao = new TradeDao();
		List<Trade> trades = tdao.getTradeByUserid(user.getId());
		
		req.setAttribute("tradeHistory",trades);
		
//		List<Trade> portfolio = new ArrayList<Trade>(trades);
//		
//		List<Trade> portfolio2 = new ArrayList<Trade>();
//		
//		for(Trade t : portfolio) {
//			if(!portfolio2.contains(t)) {
//				portfolio.remove(t);
//				for(Trade tr : portfolio) {
//					if(tr.getCompanyid() == t.getCompanyid()) {
//						t.setQuantity(t.getQuantity()+tr.getQuantity());
//						portfolio.remove(tr);
//					}
//				}
//				portfolio2.add(t);
//			}
//		}
//		
//		req.setAttribute("portfolio",portfolio2);
//		
		RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
		rd.forward(req, res);
		
		System.out.println("pass through filter");
		
		chain.doFilter(req, res);
	}
		
		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
