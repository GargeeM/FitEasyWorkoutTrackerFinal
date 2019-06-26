package com.ibm.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.model.WTReportDao;

@WebServlet("/report")
public class DailyReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	WTReportDao dao;
	String email;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/html");
		dao = new WTReportDao();
		email = (String) request.getSession().getAttribute("email");
		String reporttype = request.getParameter("reporttype"); 
		
		if(reporttype.equals("dailyReport")) {
			
			ResultSet rs1 = dao.fetchDailyData(email, request, response, getServletContext());
			response.getWriter().print("<tr style='color:#282828'><th colspan='4'>Daily Workout Report</th></tr>");
			response.getWriter().print("<tr><th>Workout Plan</th><th>Activity Name</th><th>Time Taken</th><th>Calories Burnt</th></tr>");
		
			try {
				System.out.println("inside try of report servlet");
				while (rs1.next()) {
					System.out.println("inside while of report servlet");
					response.getWriter().print("<tr><td>" + rs1.getString("workout_plan") + "</td>");
					System.out.println("from report servlet: " + rs1.getString("workout_plan"));
					response.getWriter().print("<td>" + rs1.getString("activity_name") + "</td>");
					response.getWriter().print("<td>" + rs1.getDouble("time_taken") + "</td>");
					response.getWriter().print("<td>" + rs1.getDouble("cal_burnt") + "</td>");
					
				}
			} catch (SQLException e) {

				System.out.println("Some issue occured :" + e.getMessage());
			}
			try {
				rs1.close();
			} catch (SQLException e) {
				System.out.println("ResultSet not closed: " + e.getMessage());
			}

			ResultSet rsnew = dao.calculateDailyTotal(email,request, response, getServletContext());
			try {
				while (rsnew.next()) {
					response.getWriter().print("<tr><td colspan='2'>Total</td>");
					response.getWriter().print("<td>" + rsnew.getDouble(1) + "</td>");
					response.getWriter().print("<td>" + rsnew.getDouble(2) + "</td></tr>");
				}
			} catch (SQLException e) {

				System.out.println("Some issue occured :" + e.getMessage());
			}
			try {
				rsnew.close();
			} catch (SQLException e) {
				System.out.println("ResultSet not closed: " + e.getMessage());
			}

		}

		if(reporttype.equals("weeklyReport")) {
		ResultSet rs1 = dao.fetchWeeklyData(email,request, response, getServletContext());
		response.getWriter().print("<tr><th colspan='5'>Weekly Workout Report</th></tr>");
		response.getWriter().print("<tr><th>Workout Plan</th><th>Activity Name</th><th>Time Taken</th><th>Calories Burnt</th><th>Date</th></tr>");
	
		try {
			while (rs1.next()) {
				
				response.getWriter().print("<tr><td>" + rs1.getString("workout_plan") + "</td>");
				response.getWriter().print("<td>" + rs1.getString("activity_name") + "</td>");
				response.getWriter().print("<td>" + rs1.getDouble("time_taken") + "</td>");
				response.getWriter().print("<td>" + rs1.getDouble("cal_burnt") + "</td>");
				response.getWriter().print("<td>" + rs1.getString("date") + "</td></tr>");
			}
		} catch (SQLException e) {

			System.out.println("Some issue occured :" + e.getMessage());
		}
		try {
			rs1.close();
		} catch (SQLException e) {
			System.out.println("ResultSet not closed: " + e.getMessage());
		}

		ResultSet rsnew = dao.calculateWeeklyTotal(email, request, response, getServletContext());
		try {
			while (rsnew.next()) {
				response.getWriter().print("<tr><td colspan='2'>Total</td>");
				response.getWriter().print("<td>" + rsnew.getDouble(1) + "</td>");
				response.getWriter().print("<td>" + rsnew.getDouble(2) + "</td></tr>");
			}
		} catch (SQLException e) {

			System.out.println("Some issue occured :" + e.getMessage());
		}
		try {
			rsnew.close();
		} catch (SQLException e) {
			System.out.println("ResultSet not closed: " + e.getMessage());
		}

	}
	

	if(reporttype.equals("monthlyReport")) {
		
		ResultSet rs1 = dao.fetchMonthlyData(email, request, response, getServletContext());
		response.getWriter().print("<tr><th colspan='5'>Monthly Workout Report</th></tr>");
		response.getWriter().print("<tr><th>Workout Plan</th><th>Activity Name</th><th>Time Taken</th><th>Calories Burnt</th><th>Date</th></tr>");
	
		try {
			while (rs1.next()) {
				
				response.getWriter().print("<tr><td>" + rs1.getString("workout_plan") + "</td>");
				response.getWriter().print("<td>" + rs1.getString("activity_name") + "</td>");
				response.getWriter().print("<td>" + rs1.getDouble("time_taken") + "</td>");
				response.getWriter().print("<td>" + rs1.getDouble("cal_burnt") + "</td>");
				response.getWriter().print("<td>" + rs1.getString("date") + "</td></tr>");
			}
		} catch (SQLException e) {

			System.out.println("Some issue occured :" + e.getMessage());
		}
		try {
			rs1.close();
		} catch (SQLException e) {
			System.out.println("ResultSet not closed: " + e.getMessage());
		}

		ResultSet rsnew = dao.calculateMonthlyTotal(email,request, response, getServletContext());
		try {
			while (rsnew.next()) {
				response.getWriter().print("<tr><td colspan='2'>Total</td>");
				response.getWriter().print("<td>" + rsnew.getDouble(1) + "</td>");
				response.getWriter().print("<td>" + rsnew.getDouble(2) + "</td></tr>");
			}
		} catch (SQLException e) {

			System.out.println("Some issue occured :" + e.getMessage());
		}
		try {
			rsnew.close();
		} catch (SQLException e) {
			System.out.println("ResultSet not closed: " + e.getMessage());
		}

	}
	}
}
