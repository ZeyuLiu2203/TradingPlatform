package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.User;

public class LoginServlet extends HttpServlet{
	
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");//name of input
		String password = req.getParameter("password");
		
		UserDao udao = new UserDao();
		
		int result = Integer.parseInt(username);
		User foundUser =  udao.findById(result);
		System.out.println("3");
		if(password != null && password.equals(foundUser.getPassword())) {
			
			
			HttpSession session = req.getSession();
			session.setAttribute("loggedInUser", foundUser);
			
			
			
			RequestDispatcher rd = req.getRequestDispatcher("welcome.jsp");
			rd.forward(req, res);
			
		}else {
			req.setAttribute("error","invalid username/password");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
		}
	}
}
