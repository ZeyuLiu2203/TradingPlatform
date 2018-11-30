package com.fdmgroup.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fdmgroup.model.User;

public class TestFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	
		System.out.println("Inside the TestFilter");
		HttpSession session = ((HttpServletRequest) req).getSession();
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if(loggedInUser != null) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, res);
		}else {
			
		chain.doFilter(req, res);
		}
		
	}
		
		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
