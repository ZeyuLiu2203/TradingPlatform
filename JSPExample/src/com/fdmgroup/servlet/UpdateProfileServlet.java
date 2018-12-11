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

public class UpdateProfileServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username3");
		String oldPassword = request.getParameter("password3");
		String newPassword = request.getParameter("password4");
		String email = request.getParameter("email3");
		String firstname = request.getParameter("firstname3");
		String lastname = request.getParameter("lastname3");
		
	
		HttpSession session = request.getSession();

		UserDao udao = new UserDao();

		User user = (User) session.getAttribute("loggedInUser");

		if(oldPassword.equals(user.getPassword()) ){
			
			user.setEmail(email);
			user.setUsername(username);
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setPassword(newPassword);
			udao.update(user);
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}else {
			System.out.println("inside else");
			request.setAttribute("error", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
	}

}
