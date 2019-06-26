package com.ibm.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.WorkoutSpecs;
import com.ibm.model.WTDao;


@WebServlet("/workout")
public class WorkoutDetailsServlet extends HttpServlet {
	WorkoutSpecs worksp;
	WTDao dao = new WTDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = (String) request.getSession().getAttribute("email");
		System.out.println("email from session workout:" + email );
		String workoutPlan = "Light";
		String activityName = request.getParameter("activityName");
		Double timeTaken = Double.parseDouble(request.getParameter("timeTaken"));
		Double weight = dao.getWeight(request, response, getServletContext(), email);
		
		
		DecimalFormat df = new DecimalFormat("#.####");
		//String calorieBurntStr = df.format((timeTaken/60)/weight);
		Double calorieBurnt = Double.parseDouble(df.format((timeTaken/60)/weight));
		System.out.println("floored calorie value: " + calorieBurnt);
		response.getWriter().print(calorieBurnt + " Calories/min");
		//current date format
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		
		String date = dtf.format(now);
		worksp = new WorkoutSpecs(email, workoutPlan, activityName, date, timeTaken, calorieBurnt);
		System.out.println("dao value from servlet: " + dao);
		System.out.println("Email from servlet: " + worksp.getEmail());
		dao.createActivityLog(request, response, getServletContext(), worksp);
	}

}
