package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.util.RequestHelper;

//this connects the backend and frontend through the uri
public class FrontController extends HttpServlet{
	private static final Logger logger = LogManager.getLogger(FrontController.class.getName());
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		logger.debug("in post");
		System.out.println(req.getRequestURI());
		final String URI = req.getRequestURI().replace("/project-1/", "");
		System.out.println(URI);
		switch(URI) {
		case "login": RequestHelper.processLogin(req, res);
			break;
		case "logout": RequestHelper.processLogout(req, res);
			break;
		case "employees": RequestHelper.processEmployees(req, res);
			System.out.println("post was sent");
			break;
		//TODO: add reimbursement
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("in get");
		doPost(req, res);
		System.out.println("get was sent");
		//TODO: I need to make sure these just do the same thing, but with get or post commands
	}
}
