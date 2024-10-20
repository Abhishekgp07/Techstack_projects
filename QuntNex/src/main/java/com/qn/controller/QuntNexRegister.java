package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qn.model.Quntnex;


public class QuntNexRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		String email=request.getParameter("email");
		String qualification=request.getParameter("qualification");
		String cgpa=request.getParameter("cgpa");
		
		if(password.equals(confirmpassword)) {
			Quntnex qn = new Quntnex(name,username,password,email,qualification,cgpa);
			int rows=qn.QuntNexRegister();
			if(rows == 0) {
				response.sendRedirect("/QuntNex/QuntNexRegisterFailur.jsp");
			}else {
				response.sendRedirect("/QuntNex/QuntNexRegisterSucess.jsp");
			}
		}
		else {
			response.sendRedirect("/QuntNex/PasswordMismatch.html");
		}
		}
	}

