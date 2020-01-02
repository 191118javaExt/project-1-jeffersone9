package com.revature.models;

import java.io.Serializable;
import java.time.LocalDateTime;

//employee will have a date version for hire date to get from db
public class Employee implements Serializable {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private EmployeeRole role;
	private static final long serialVersionUID = 1L;
	
	//constructors
	public Employee() {
		super();
	}
	
	public Employee(int id, String username, String password, String fName, String lName, String email, EmployeeRole role) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = fName;
		this.lastName = lName;
		this.role = role;
	}
	//getters and setters
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeRole getRole() {
		return role;
	}
	public void setRole(EmployeeRole role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
