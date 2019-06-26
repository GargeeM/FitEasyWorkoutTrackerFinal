package com.ibm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.WorkoutSpecs;
import com.ibm.model.GetCaloriesDao;


@WebServlet("/graph")
public class PerformanceGraphServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		
		ArrayList<WorkoutSpecs> dataList = GetCaloriesDao.getData(email, request, response, getServletContext());
		request.setAttribute("dataList", dataList);
		ArrayList<WorkoutSpecs> newdataList = GetCaloriesDao.getNewData(email, request, response, getServletContext());
		request.setAttribute("newdataList", newdataList);
		request.getRequestDispatcher("performanceGraph.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
