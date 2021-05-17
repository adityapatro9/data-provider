package com.aditya.dataprovider.model;

public class User {
	
	String firstName;
	String lastName;
	String profession;
	String contactNo;
	String emailId;
	
	public User(String firstName, String lastName, String profession, String contactNo, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.profession = profession;
		this.contactNo = contactNo;
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
