package com.doa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.dto.EmployeeDTO;

public class EmployeeTable {
	
		 public EmployeeTable(){
			createTable();
		}
		
		
		public void createTable() {
			
			Statement st = null;
			Connection con = ConnectionFactory.getConnection();
			
			try {
				
				String sql = "CREATE TABLE IF NOT EXISTS employee ("
				        + "eid VARCHAR(30) UNIQUE NOT NULL, "
				        + "name VARCHAR(50), "
				        + "email VARCHAR(50), "
				        + "address VARCHAR(80), "
				        + "salary VARCHAR(30)"
				        + ");";
				st = con.createStatement();
				st.executeUpdate(sql);
				System.out.println(con);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				try {
					ConnectionFactory.closeConnection(st);
					ConnectionFactory.closeConnection(con);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		}
		
		public int insertData(EmployeeDTO edto) {
			
			PreparedStatement ps =null;
			Connection con = ConnectionFactory.getConnection();
			int res =0;
			
			
			try {
				
				String sql="insert into employee(eid,name,email,address,salary) value(?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, edto.getEid());
				ps.setString(2, edto.getName());
				ps.setString(3, edto.getEmail());
				ps.setString(4, edto.getAddress());
				ps.setString(5, edto.getSalary());
				res = ps.executeUpdate();
				return res;
				
			} catch (Exception e) {
				System.out.println("Exception Occur");
				e.printStackTrace();
				return res;
			}
			finally {
				ConnectionFactory.closeConnection(ps);
				ConnectionFactory.closeConnection(con);
			}
		}


	}



