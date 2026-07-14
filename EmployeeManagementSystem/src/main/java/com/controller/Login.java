package com.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.AdminTable;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String data = (String) session.getAttribute("data");
		
		if(data!=null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/home.jsp");
			requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		AdminTable curd = new AdminTable();
		ResultSet resultSet = curd.accessDetail(email, password);
		
		String tableEmail = null;
		String tablePassword = null;
		
		try {
			
			if(resultSet.next()) {
				
				tableEmail = resultSet.getString("email");
				tablePassword = resultSet.getString("password");
			}
			
			if(email.equals(tableEmail) && password.equals(tablePassword)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("data", email);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/home.jsp");
				requestDispatcher.forward(request, response);
				
				
			}else {
				request.setAttribute("msg", "Firstly Complete the Registration");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		        rd.forward(request, response);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
