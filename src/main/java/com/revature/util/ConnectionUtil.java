package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {
	private static Logger logger = LogManager.getLogger(ConnectionUtil.class);
	
	public static Connection getConnection() {
		
		//first lets make sure the Driver class is initialized
		try {
			Class.forName("org.posgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		//this is going to hold the properties for the jdbc connection
		Properties props = new Properties();
		//the loader tells the project to search for files in the project
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Connection conn = null;
		try {
			//grabs the properties from the properties file in resources
			props.load(loader.getResourceAsStream("connection.properties"));
			String url = props.getProperty("url");
			String username = props.getProperty("username");
			String password = props.getProperty("password");
			try {
				conn = DriverManager.getConnection(url, username, password);
			}catch(SQLException e) {
				logger.warn("Unable to get connection from db", e);
			}
		}catch(IOException ex){
			logger.warn("Properties file not found", ex);
		}
		return conn;
	}
}
