package com.ibm.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.User;
import com.ibm.bean.UserBiometrics;
import com.ibm.bean.WorkoutSpecs;

public class WTDao {
   PreparedStatement prepStmt;
   Connection dbCon;

   public int createUser(HttpServletRequest request, HttpServletResponse response, ServletContext context, User user){
	   dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
	   String insertQry ="insert into user_master values(?, ?, ?, ?)";
	   int flag = 0;
	   try {
		   this.prepStmt = this.dbCon.prepareStatement(insertQry);
		   
		   this.prepStmt.setString(1, user.getEmail());
		   this.prepStmt.setString(2, user.getUserName());
		   this.prepStmt.setString(3, user.getPassword());
		   this.prepStmt.setString(4, user.getContact());
		   
		   if(this.prepStmt.executeUpdate()>0) {
			   flag = 1;
		   }
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
	   return flag;
   }
   
   public void login(HttpServletRequest request, HttpServletResponse response, ServletContext context) {
	   
   }
   

	public int checkUser(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext,
			User user) {
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		int flag=1;
		String email = user.getEmail();
		String pw = user.getPassword();
		
		PreparedStatement ps;
		try {
			ps = dbCon.prepareStatement("select userName, password from user_master where email=? and password=?");
	
			ps.setString(1, email);
		
		ps.setString(2, pw);

		ResultSet rs = ps.executeQuery();
		if (!rs.next() ) {
		    flag=0;
		} 
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
		
		return flag;
	}
   
    public int setBiometricDetails(HttpServletRequest request, HttpServletResponse response, ServletContext context, UserBiometrics usrBio){
       PreparedStatement theStatement;
       int flag = 0;
       dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		try{			
			String insertQry = "INSERT INTO user_biometrics VALUES (?,?,?,?,?)";
		            	      
		            theStatement = (PreparedStatement) dbCon.prepareStatement(insertQry);
		            theStatement.setString(1, usrBio.getEmail());
					theStatement.setString(2, usrBio.getGender());
					theStatement.setDouble(3, usrBio.getHeight());
					theStatement.setDouble(4, usrBio.getWeight());
					theStatement.setInt(5, usrBio.getAge());
					//Execute the query
					if(theStatement.executeUpdate() > 0) {
						//System.out.println("User Biometric details inserted...");
						flag = 1;
						
					}
					else
					{
						//System.out.println("Some issues...");
						flag = 0;
					}
		            } 
		            catch (Exception ex) {
		            System.out.println("Unable to connect to database.");
		 			}
		            /* finally {
		            // close all the connections.
		            theStatement.close();
		            dbCon.close();
		            } */
		return flag;
	}
   
   public void createActivityLog(HttpServletRequest request, HttpServletResponse response, ServletContext context, WorkoutSpecs worksp) {
	   dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
	   String insertQry ="insert into workout_details values(?, ?, ?, ?, ?, ?)";
	   try {
		   this.prepStmt = this.dbCon.prepareStatement(insertQry);
		   System.out.println("dbcon value from dao class: " + dbCon);
		   System.out.println("Email from dao class: " + worksp.getEmail());
		   this.prepStmt.setString(1, worksp.getEmail());
		   this.prepStmt.setString(2, worksp.getWorkoutPlan());
		   this.prepStmt.setString(3, worksp.getActivityName());
		   this.prepStmt.setDouble(4, worksp.getTimeTaken());
		   this.prepStmt.setDouble(5, worksp.getCalBurnt());
		   this.prepStmt.setString(6, worksp.getDate());
		     
		   if(this.prepStmt.executeUpdate()>0) {
		      System.out.println("Query getting executed");
		   }
		   else
			   System.out.println("not executed");
	   }catch(SQLException e) {
		   e.printStackTrace();
	   }
   }

	public Double getWeight(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext,
			String email) {
		Connection dbCon = (Connection) request.getServletContext().getAttribute("dbCon");
		Double weight=0.0;
		
		PreparedStatement ps;
		try {
			ps = dbCon.prepareStatement("select weight from user_biometrics where email=?");
			ps.setString(1, email);
	
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			    weight = rs.getDouble("weight");
			} 
		} catch (SQLException e1) {
	
			e1.printStackTrace();
		}
		System.out.println("Weight from dao: " + weight);
		return weight;
	}
}
