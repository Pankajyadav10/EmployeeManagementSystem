package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doa.ConnectionFactory;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String eid = request.getParameter("eid");
	        

	        Connection con = null;
	        PreparedStatement ps = null;

	        try {

	            con = ConnectionFactory.getConnection();

	            String sql = "DELETE from employee WHERE eid=?";

	            ps = con.prepareStatement(sql);

	            ps.setString(1, eid);

	            int result = ps.executeUpdate();

	            if(result > 0) {

	                request.setAttribute("msg", "Deleted Successfully");

	            } else {

	                request.setAttribute("msg", "Employee ID Not Found");

	            }

	        } catch(Exception e) {

	            e.printStackTrace();
	            request.setAttribute("msg", "Database Error");

	        } finally {

	            try {

	                if(ps != null)
	                    ps.close();

	                if(con != null)
	                    con.close();

	            } catch(Exception e) {

	                e.printStackTrace();

	            }

	        }

	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deleteEmployee.jsp");

	        rd.forward(request, response);
		
	}

}
