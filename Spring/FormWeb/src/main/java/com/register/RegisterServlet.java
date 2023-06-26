package com.register;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("hello");
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("mail");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");

		String cond = request.getParameter("terms");

		if (cond!=null && cond.equals("checked")) {
			out.println("<h2> Successfully Registered</h2>");
			out.println("<h2> Course :" + course + "</h2>");
			out.println("<h2> Name :" + name + "</h2>");
			out.println("<h2> Email :" + email + "</h2>");
			out.println("<h2> Gender : " + gender + "</h2");
			

		} else{
			out.println("<h2>Must Agree the Terms and conditions</h2>");
		}
	}
}
