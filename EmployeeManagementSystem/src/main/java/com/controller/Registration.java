package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doa.AdminTable;
import com.dto.AdminDTO;

@WebServlet("/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		AdminDTO adto = new AdminDTO(fullname, email, password);
		
		if(password.equals(cpassword)) {
			
			AdminTable curd = new AdminTable();
			int res = curd.insertData(adto);
			if(res==1) {
	            request.setAttribute("msg", "Registration Successfully.");
	        } else {
	            request.setAttribute("msg", "Failed to Insert Data.");
	        }
			//out.println("<h1>REGISTRATION SUCCESSFULLY </h1>");
			
		}else {
			request.setAttribute("msg", "Enter Both Not Password Same");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
		
	}

}
