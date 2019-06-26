package com.ibm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.ibm.bean.UserBiometrics;
import com.ibm.model.WTDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class BiometricsServlet
 */
@WebServlet("/biometrics")
public class BiometricsServlet extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email,gender;
		Double height,weight;
		Integer age;
		
		ServletContext theContext = request.getServletContext();
		PrintWriter out = response.getWriter();
		
		email = (String) request.getSession().getAttribute("email");
		gender = request.getParameter("radgender");
		height = java.lang.Double.parseDouble(request.getParameter("height"));
		System.out.println("request from bioservlet: " + request);
		weight = java.lang.Double.parseDouble(request.getParameter("weight"));
		request.getSession().setAttribute("weight", weight);
		age = Integer.parseInt(request.getParameter("age"));
		UserBiometrics usrBio = new UserBiometrics(email,gender,height,weight,age);
		WTDao dao = new WTDao();
		int flag = dao.setBiometricDetails(request, response, theContext, usrBio);
		if(flag == 1) {
			request.getRequestDispatcher("lightworkoutplan.jsp").forward(request,response);
		}
		else {
			request.getRequestDispatcher("biometrics.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
