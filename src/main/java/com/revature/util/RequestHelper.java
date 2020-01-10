package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.LoginTemplate;
import com.revature.services.EmployeeService;

public class RequestHelper {
	private static Logger logger = LogManager.getLogger(RequestHelper.class);
	//this will be used to convert the login object into a json
	private static ObjectMapper om = new ObjectMapper();
	
	public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException{
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		System.out.println(body);
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class);
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();
		logger.info("User attempted to login as " + username);
		
		Employee e = EmployeeService.login(username, password);
		if(e != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			PrintWriter out = res.getWriter();
			//TODO: I think I understand, but make sure
			res.setContentType("applications/json");
			//TODO: I might have to convert reimbursements to DTO here
			out.println(om.writeValueAsString(e));
			logger.info(username + " has successfully logged in");
		}
		else {
			res.setContentType("application/json");
			res.setStatus(204);
		}
	}
	
	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession session = req.getSession(false);
		if(session != null) {
			String username = (String)session.getAttribute("username");
			logger.info(username + " has logged out");
			session.invalidate();
		}
		
		res.setStatus(200);
	}
	
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setContentType("application/json");
		List<Employee> all = EmployeeService.findAll();
		String json = om.writeValueAsString(all);
		PrintWriter out = res.getWriter();
		out.println(json);
	}
	//TODO: Need to process adding and getting reimbursements
}
