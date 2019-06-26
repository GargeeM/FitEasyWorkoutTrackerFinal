package com.ibm.bean;

public class UserBiometrics {
	String email,gender;
	Double height, weight;
	int age;
	
	public UserBiometrics(String email, String gender, Double height, Double weight, int age) {
		this.email = email;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}
	
	public UserBiometrics() {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public Double getWeight() {
		return weight;
	}
	
	public int getAge() {
		return age;
	}
}
