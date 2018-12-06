package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.CompanyDao;
import com.fdmgroup.dao.UserDao;
import com.fdmgroup.model.Company;
import com.fdmgroup.model.User;

public class DeleteUserServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		
		int stockidint = Integer.parseInt(userid);
		
		UserDao udao = new UserDao();
		HttpSession session = request.getSession();
		
		User u = udao.findById(stockidint);
		udao.remove(u);
		
		List<User> users = udao.findAll();
		session.setAttribute("allUsers",users);
		
		RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
		rd.forward(request, response);
	}

}
