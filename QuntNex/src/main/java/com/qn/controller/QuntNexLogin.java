package com.qn.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Quntnex;


public class QuntNexLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			Quntnex q=new Quntnex();
			q.setUsername(username);
			q.setPassword(password);
			
			int status=q.QuntNexLogin();
			if(status == 1) {
				String name=q.getName();
				HttpSession session = request.getSession();
				session.setAttribute("sname", name);
				session.setAttribute("susername", username);
				
				response.sendRedirect("/QuntNex/QuntnexLoginSuccess.jsp");
			}
			else if(status == 0) {
				response.sendRedirect("/QuntNex/invalidQuntNexUserName.jsp");
			}
			else {
			
				response.sendRedirect("/QuntNex/invalidQuntNexPassword.jsp");
			}
			}

		
		
	}

