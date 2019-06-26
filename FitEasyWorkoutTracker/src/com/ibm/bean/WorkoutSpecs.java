package com.ibm.bean;

public class WorkoutSpecs {
   String email, workoutPlan, activityName, date;
   Double timeTaken, calBurnt;
   
   public WorkoutSpecs(String email, String workoutPlan, String activityName, String date, Double timeTaken,
		Double calBurnt) {
	super();
	this.email = email;
	this.workoutPlan = workoutPlan;
	this.activityName = activityName;
	this.date = date;
	this.timeTaken = timeTaken;
	this.calBurnt = calBurnt;
   }
   
   public WorkoutSpecs() {
	   
   }
   
   public WorkoutSpecs(Double timeTaken, Double calBurnt) {
		this.timeTaken = timeTaken;
		this.calBurnt = calBurnt;
		
	}

	public WorkoutSpecs(String workoutPlan, String activityName, String date, Double timeTaken, Double calBurnt) {
		super();
		this.workoutPlan = workoutPlan;
		this.activityName = activityName;
		this.date = date;
		this.timeTaken = timeTaken;
		this.calBurnt = calBurnt;
	}

	public void setEmail(String email) {
	this.email = email;
	}
	
	public void setWorkoutPlan(String workoutPlan) {
		this.workoutPlan = workoutPlan;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setTimeTaken(Double timeTaken) {
		this.timeTaken = timeTaken;
	}
	
	public void setCalBurnt(Double calBurnt) {
		this.calBurnt = calBurnt;
	}

	public String getEmail() {
		return email;
	}
	
	public String getWorkoutPlan() {
		return workoutPlan;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public String getDate() {
		return date;
	}
	
	public Double getTimeTaken() {
		return timeTaken;
	}
	
	public Double getCalBurnt() {
		return calBurnt;
	}
   
   
   
   
}
