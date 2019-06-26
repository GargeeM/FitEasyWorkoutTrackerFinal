package com.ibm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.User;
import com.ibm.model.WTDao;

@WebServlet("/login")

public class LoginController extends HttpServlet {

	WTDao dao = new WTDao();
	User user;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		System.out.println("Email from logincontr: " + email);
		String pw = request.getParameter("psw");
		request.getSession().setAttribute("email", email);

	// Connect to mysql and verify email and password
     user=new User(email, pw);
     
     int flag = dao.checkUser(request, response, getServletContext(), user);
     
			if(flag == 1) {
				response.getWriter().println("success");
				
			} else {
				response.getWriter().println("<h6>Login failed! Try Again</h6>");
				request.getSession().invalidate();
			}
			
			}
		
		}
	


