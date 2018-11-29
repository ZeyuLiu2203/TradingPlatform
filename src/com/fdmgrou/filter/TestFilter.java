package com.fdmgrou.filter;

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
		
		
		HttpSession session = ((HttpServletRequest) req).getSession();
		User loggedInUser = (User) session.getAttribute("LoggedInUser");
		if(loggedInUser != null) {//check if the user has already logged in
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, res);
		}else {
//		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//		rd.forward(req, res);
			
			chain.doFilter(req, res);
		}
		
	
		
		System.out.println("diulei loumou");
		
	
}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
}
