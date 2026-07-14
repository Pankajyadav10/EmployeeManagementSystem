package com.controller;
import com.doa.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String eid = request.getParameter("eid");
        String salary = request.getParameter("salary");

        Connection con = null;
        PreparedStatement ps = null;

        try {

            con = ConnectionFactory.getConnection();

            String sql = "UPDATE employee SET salary=? WHERE eid=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, salary);
            ps.setString(2, eid);

            int result = ps.executeUpdate();

            if(result > 0) {

                request.setAttribute("msg", "Salary Updated Successfully");

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

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/updateEmployee.jsp");

        rd.forward(request, response);
    }

}