package com.revature.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HtmlTemplate {
	
	public static void goBack(PrintWriter out) {
		out.println("<hr><input type='button' value='back'" + 
					"onclick='goBack()'>" +
					"<script>" + 
					"function goBack{ windows.history.back(); }" +
					"</script>");
	}
	
	//TODO: I dont fully understand res.setContentType
	public static PrintWriter getHtmlWriter(HttpServletResponse res) throws IOException{
		res.setContentType("");
		return res.getWriter();
	}
	
	public static void printTableHeaders(PrintWriter out, String ...headers) {
		out.println("<table border=2px<tr>");
		for(String h : headers) {
			out.println("<th>" + h + "</th>");
		}
		out.println("</tr>");
	}
}
