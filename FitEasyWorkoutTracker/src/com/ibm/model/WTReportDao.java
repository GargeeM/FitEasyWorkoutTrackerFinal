package com.ibm.model;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ibm.bean.WorkoutSpecs;

public class WTReportDao {
	WorkoutSpecs work;
	
	public ResultSet fetchDailyData(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String fetchQry = "Select workout_plan,activity_name,Sum(time_taken) as time_taken,truncate(sum(cal_burnt),4) as cal_burnt from workout_details where email=? and date=CURDATE() group by activity_name";

			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

				} catch (SQLException e) {

			System.out.println("Problem in loading class: " + e.getMessage());
		}

		return rs;

	}

	public ResultSet calculateDailyTotal(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		ResultSet rsnew=null;
		try {
			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String timeQry = "select sum(time_taken) as time_taken,truncate(sum(cal_burnt),4)as cal_burnt from workout_details where email=? and date=CURDATE()";
			PreparedStatement pstmtnew = dbCon.prepareStatement(timeQry);
			pstmtnew.setString(1, email);
			rsnew = pstmtnew.executeQuery();
		} catch (SQLException e1) {
			System.out.println("Some problem occur: " + e1.getMessage());
		}
		return rsnew;
	}

	
	public ResultSet fetchWeeklyData(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String fetchQry = "SELECT workout_plan,activity_name,Sum(time_taken) as time_taken,truncate(sum(cal_burnt),4) as cal_burnt,date FROM workout_details WHERE email = ? and DATE <= CURDATE() AND "
					+ "DATE>= DATE_SUB( CURDATE(), INTERVAL 6 DAY ) group by date,activity_name order by Date";

			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			} catch (SQLException e) {
				System.out.println("Problem in loading class: " + e.getMessage());
			}
		return rs;
	}

	
	public ResultSet calculateWeeklyTotal(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		ResultSet rsnew = null;
		try {
			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String timeQry = "SELECT SUM(time_taken) as time_taken,truncate(sum(cal_burnt),4) AS cal_burnt FROM workout_details"
					+ " WHERE email =? and DATE <= CURDATE() AND "
					+ "DATE>= DATE_SUB( CURDATE(), INTERVAL 6 DAY ) ORDER BY DATE";
			PreparedStatement pstmtnew = dbCon.prepareStatement(timeQry);
			pstmtnew.setString(1, email);
			rsnew = pstmtnew.executeQuery();
			} catch (SQLException e1) {
			System.out.println("Some problem occur: " + e1.getMessage());
		}
		return rsnew;
	}

	public ResultSet fetchMonthlyData(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String fetchQry = "SELECT workout_plan,activity_name,Sum(time_taken) as time_taken,truncate(sum(cal_burnt),4) as cal_burnt,date FROM workout_details WHERE email =? AND MONTH(date) = MONTH(CURRENT_DATE())"
					+ "AND YEAR(date) = YEAR(CURRENT_DATE()) group by date,activity_name order by date";
			pstmt = dbCon.prepareStatement(fetchQry);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			} catch (SQLException e) {

			System.out.println("Problem in loading class: " + e.getMessage());
		}

		return rs;

	}

	public ResultSet calculateMonthlyTotal(String email,HttpServletRequest request, HttpServletResponse response, ServletContext context) {
		ResultSet rsnew=null;
		try {
			Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
			String timeQry = "SELECT sum(time_taken)as time_taken, truncate(sum(cal_burnt),4) as cal_burnt FROM workout_details WHERE email =? AND MONTH(date) = MONTH(CURRENT_DATE())"
					+ "AND YEAR(date) = YEAR(CURRENT_DATE())";
			PreparedStatement pstmtnew = dbCon.prepareStatement(timeQry);

			pstmtnew.setString(1, email);

			
			rsnew = pstmtnew.executeQuery();

			} catch (SQLException e1) {
			System.out.println("Some problem occur: " + e1.getMessage());
		}

		return rsnew;

	}

}
