package com.ibm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.WorkoutSpecs;

public class GetCaloriesDao {
	
	public static ArrayList<WorkoutSpecs> getData(String email, HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		
		ArrayList<WorkoutSpecs> list = new ArrayList<>();
		
		//DatabaseUtility dbU = new DatabaseUtility();
		try {
			Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
			String sql = "SELECT SUM(cal_burnt) AS cal_burnt, DATE_FORMAT(DATE, '%W') AS date1 FROM workout_details WHERE email = ? GROUP BY DATE HAVING DATE <= CURDATE() AND DATE>= DATE_SUB( CURDATE(), INTERVAL 7 DAY ) ORDER BY DATE";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				//WorkoutDetails wDetails = new WorkoutDetails();
				WorkoutSpecs wDetails = new WorkoutSpecs();

				wDetails.setCalBurnt(rs.getDouble("cal_burnt"));
				wDetails.setDate(rs.getString("date1"));

				list.add(wDetails);
			}
			System.out.println(list.size());
			//conn.close();
			statement.close();
			
		} catch (SQLException e) {
			System.out.println("Issues while Fetching Value  : " + e);
		}
	            
	            
	return list;
	}
	
	public static ArrayList<WorkoutSpecs> getNewData(String email, HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		ArrayList<WorkoutSpecs> list = new ArrayList<>();
		
		//DatabaseUtility dbU = new DatabaseUtility();
		try {
			Connection conn = (Connection) request.getServletContext().getAttribute("dbCon");
			String sql = "SELECT  SUM(cal_burnt) AS cal_burnt, DATE_FORMAT(DATE, '%d/%m/%y') AS date1 FROM workout_details WHERE email = ? GROUP BY DATE HAVING DATE <= CURDATE() AND DATE>= DATE_SUB( CURDATE(), INTERVAL 30 DAY ) ORDER BY DATE";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				WorkoutSpecs wDetails = new WorkoutSpecs();

				wDetails.setCalBurnt(rs.getDouble("cal_burnt"));
				wDetails.setDate(rs.getString("date1"));

				list.add(wDetails);
			}
			System.out.println(list.size());
			statement.close();
			
		} catch (SQLException e) {
			System.out.println("Issues while Fetching Value  : " + e);
		}
	            
	            
	return list;
	}

}
