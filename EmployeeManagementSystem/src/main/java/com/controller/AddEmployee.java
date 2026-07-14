package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doa.EmployeeTable;
import com.dto.EmployeeDTO;

@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String data = (String) session.getAttribute("data");

		if (data != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/home.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String salary = request.getParameter("salary");

		EmployeeDTO edto = new EmployeeDTO(eid, ename, email, address, salary);
		EmployeeTable employeeTable = new EmployeeTable();
		int insertData = employeeTable.insertData(edto);

		if (insertData == 1) {
			request.setAttribute("msg", "Data Inserted Successfully.");
		} else {
			request.setAttribute("msg", "Failed to Insert Data.");
		}

		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/addEmployee.jsp");
		rd.forward(request, response);

	}

}
