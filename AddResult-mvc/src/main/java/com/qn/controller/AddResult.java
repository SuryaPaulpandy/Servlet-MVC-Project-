package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Student;


public class AddResult extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int Marks1 = Integer.parseInt(request.getParameter("Marks1"));
		int Marks2 = Integer.parseInt(request.getParameter("Marks2"));
		int Marks3 = Integer.parseInt(request.getParameter("Marks2"));
		Student tempstudent = new Student();
		tempstudent.setId(id);
		tempstudent.setName(name);
		tempstudent.setMarks1(Marks1);
		tempstudent.setMarks2(Marks2);
		tempstudent.setMarks3(Marks3);
		int rows = tempstudent.addResult();
		if(rows==1) {
			response.sendRedirect("/AddResult-mvc/AddResultSuccess.html");
		}
		else {
			response.sendRedirect("/AddResult-mvc/AddResultFailure.html");
		}
	}	
}
