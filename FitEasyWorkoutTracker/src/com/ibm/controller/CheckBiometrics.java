package com.ibm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.model.WTDao;

@WebServlet("/checkbio")
public class CheckBiometrics extends HttpServlet {
	WTDao dao = new WTDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if((String) request.getSession().getAttribute("email") != null) {
			if(dao.getWeight(request, response, getServletContext(), (String) request.getSession().getAttribute("email")) == 0.0) {
				response.sendRedirect("biometrics.jsp");
			}
			else {
				response.sendRedirect("lightworkoutplan.jsp");
			}
//		}else {
//			response.sendRedirect("index.jsp");
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
