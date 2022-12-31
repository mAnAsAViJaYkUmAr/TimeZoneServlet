package com.timeZone;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeCalc extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res)throws IOException{
    try {
		String place = req.getParameter("place");
		PrintWriter out = res.getWriter();
		SimpleDateFormat sf  = new SimpleDateFormat("dd MM yyyy HH:MM:ss z");
		sf.setTimeZone(TimeZone.getTimeZone(place));
		String time = sf.format(Calendar.getInstance().getTime());
		RequestDispatcher rD = req.getRequestDispatcher("/index.html");
		rD.include(req, res);
		out.println("<h1>"+time+"<h1>");
	}
    
     catch(Exception e) {
    	 e.printStackTrace();
     }
    
	}
} 