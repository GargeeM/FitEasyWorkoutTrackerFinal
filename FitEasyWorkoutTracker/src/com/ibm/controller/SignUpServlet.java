package com.ibm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.User;
import com.ibm.model.WTDao;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	    WTDao dao = new WTDao();
	    User user;
	    
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	         resp.setContentType("text/html");
	    	String userName = req.getParameter("userName");
	    	req.getSession().setAttribute("email", req.getParameter("email"));
			String email = req.getParameter("email");
			String contact = req.getParameter("contact");
			String password = req.getParameter("password");
			user = new User(userName, email, contact, password);
			int flag = dao.createUser(req, resp, getServletContext(), user);

		    //resp.getWriter().println("Account creation failed! Try Again");
			if(flag == 1) 
				resp.sendRedirect("biometrics.jsp");
			else {
				resp.getWriter().println("<h1 style: 'color: white; margin-top: 500px'>Account creation failed! Try Again</h1>");
				req.getRequestDispatcher("index.jsp").include(req, resp);
				//resp.sendRedirect("index.jsp");
			}

	    }
	
//	    @Override
//	    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    		super.doPost(req, resp);
//	    	}
//	
}
