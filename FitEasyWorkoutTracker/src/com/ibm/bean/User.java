package com.ibm.bean;

public class User {
	String userName, email, contact, password;

	public User(String userName, String email, String contact, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public User() {
		
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getContact() {
		return contact;
	}

	public String getPassword() {
		return password;
	}
	
	

}
