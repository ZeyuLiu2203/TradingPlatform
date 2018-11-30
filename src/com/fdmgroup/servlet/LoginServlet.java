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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao udao = new UserDao();
		int result = Integer.parseInt(username);
		User foundUser = udao.findById(result);
		
			if(foundUser!= null && password != null && password.equals(foundUser.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedInUser",foundUser);
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
				
				
			}else {
				request.setAttribute("error", "Invalid username/password");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		
		
	}

}
