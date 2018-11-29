package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.model.User;

public class IndexServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User loggedInUser = (User) session.getAttribute("LoggedInUser");
		if(loggedInUser != null) {//check if the user has already logged in
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, res);
		}
		RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
		rd.forward(req, res);
		System.out.println("1");
		
		
	}
}
