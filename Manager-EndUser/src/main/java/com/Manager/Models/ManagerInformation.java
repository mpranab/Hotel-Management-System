package com.Manager.Models;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "ManagerInformation")
public class ManagerInformation {

	@Id
	private String id;
	private String email;
	private String username;
	private String password;
	private String mobileNumber;

	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setId(String id) {
		id = id;
	}
	public  void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }
	


	public ManagerInformation(String id, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public ManagerInformation() {
		super();
	}

	@Override
	public String toString() {
		return "ManagerInformation [id=" + id + ", email=" + email + ", password=" + password + "]";
	}

}
