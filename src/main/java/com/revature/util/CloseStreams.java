package com.revature.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//The point of this class is to have a single object to close all i/o streams like statements or writes
public class CloseStreams {
	private static Logger logger = LogManager.getLogger(CloseStreams.class);
	
	public static void close(Statement s) {
		try {
			s.close();
		}catch(Exception e) {
			logger.warn("Failed to close statemtnt", e);
		}
	}
	
	public static void close(Scanner s) {
		try {
			s.close();
		}catch(Exception e) {
			logger.warn("Failed to close scanner", e);
		}
	}
	
	public static void close(Connection c) {
		try {
			c.close();
		}catch(Exception e) {
			logger.warn("failed to close connection", e);
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		}catch(Exception e) {
			logger.warn("failed to close result set", e);
		}
	}
}
