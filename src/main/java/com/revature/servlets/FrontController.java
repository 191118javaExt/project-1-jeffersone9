package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

//this connects the backend and frontend through the uri
public class FrontController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		final String URI = req.getRequestURI().replace("/project-1", "");
		switch(URI) {
		case "login": RequestHelper.processLogin(req, res);
			break;
		case "logout": RequestHelper.processLogout(req, res);
			break;
		case "employees": RequestHelper.processEmployees(req, res);
			break;
		//TODO: add reimbursement
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doPost(req, res);
		//TODO: I need to make sure these just do the same thing, but with get or post commands
	}
}
