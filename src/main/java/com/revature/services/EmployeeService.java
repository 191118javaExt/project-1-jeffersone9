package com.revature.services;

import java.util.List;

import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAOImpl;

public class EmployeeService {
	private static EmployeeDAOImpl repository = new EmployeeDAOImpl();
	
	public static List<Employee> findAll(){
		return repository.findAll();
	}
	
	public static Employee findById(int id) {
		return repository.findById(id);
	}
	
	public static boolean insert(Employee e) {
		return repository.insert(e);
	}
}
