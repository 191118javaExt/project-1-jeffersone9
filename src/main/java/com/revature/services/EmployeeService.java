package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	
	public static List<Employee> findAll(){
		return new EmployeeDAOImpl().findAll();
	}
	
	public static Employee findById(int id) {
		return new EmployeeDAOImpl().findById(id);
	}
	
	public static boolean insert(Employee e) {
		return new EmployeeDAOImpl().insert(e);
	}
	
	//have the service search for employees by username
	public static Employee findByUsername(String username) {
		List<Employee> employees = new EmployeeDAOImpl().findAll();
		for(Employee e : employees) {
			if(e.getUsername().equals(username)) {
				return e;
			}
		}
		return null;
	}
	
	public static Employee login(String username, String password) {
		Employee e = findByUsername(username);
		if(e == null) {
			return null;
		}
		
		if(e.getPassword().equals(password)) {
			return e;
		} else {
			return null;
		}
	}
	
}
