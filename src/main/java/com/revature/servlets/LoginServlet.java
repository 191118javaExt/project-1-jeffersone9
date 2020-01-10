package com.revature.servlets;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.LoginTemplate;
import com.revature.services.EmployeeService;

public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger(LoginServlet.class);
	private static ObjectMapper om = new ObjectMapper();
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
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
		
		logger.info("Attempted to login is " + username);
		
		Employee e = EmployeeService.login(username, password);
		if(e != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			PrintWriter out = res.getWriter();
			res.setContentType("application/json");
			out.println(om.writeValueAsString(e));
			logger.info(username + " has logged in");
			
		}else {
			res.setContentType("application/json");
			res.setStatus(204);
		}
	}
}
