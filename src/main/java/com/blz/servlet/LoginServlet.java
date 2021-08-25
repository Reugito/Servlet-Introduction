/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        description = "Login Servlet Testing",
		//urlPatterns = {"/LoginServlet"},
		initParams = {
				@WebInitParam( name= "user", value = "Rao"),
				@WebInitParam( name= "password", value = "123")		
		}
)
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
                String user = request.getParameter("user");
		String psw = request.getParameter("psw");
               
                PrintWriter out = response.getWriter();
                boolean validateUser = Pattern.matches("[A-Z]*[a-z]{2,}",user);
                boolean validatePsw = Pattern.matches("[A-Z]*[0-9]*[!@#$%&?][a-z]{2,}",psw);
             
		if(validateUser && validatePsw) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
                       
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			//PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong</font>");
			rd.include(request, response);
		}
                
                 out = response.getWriter();
		out.println("<h1>This is my first servlet page</h1>");
		out.close();
	} 

}
