package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmpOption")
public class EmpOption extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action == null) {
			response.sendRedirect("index.jsp");
		}

		switch (action) {
		case "add": {

			request.getRequestDispatcher("WEB-INF/view/addEmployee.jsp").forward(request, response);
			break;

		}

		case "read": {

			request.getRequestDispatcher("WEB-INF/view/readData.jsp").forward(request, response);
			break;
		}
		case "update": {
			
			request.getRequestDispatcher("WEB-INF/view/updateEmployee.jsp").forward(request, response);
			break;
		}
		case "delete": {
			request.getRequestDispatcher("WEB-INF/view/deleteEmployee.jsp").forward(request, response);
			break;

		}
		case "home": {

			request.getRequestDispatcher("WEB-INF/view/home.jsp").forward(request, response);
			break;
		}
		case "logout": {
			HttpSession session = request.getSession();
			session.removeAttribute("data");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}

		}
	}

}
