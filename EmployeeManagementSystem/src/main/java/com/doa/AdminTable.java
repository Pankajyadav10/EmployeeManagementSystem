package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.dto.AdminDTO;

public class AdminTable {
		
	
	
	public AdminTable() {
		createTable();
	}
	
	
	public void createTable() {
		
		Statement st = null;
		Connection con = ConnectionFactory.getConnection();
		
		try {
			
			String sql ="CREATE TABLE IF NOT EXISTS admindata(fullname varchar(30),"
					+ "email varchar(50),"
					+ "password varchar(50));";
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
	
	public int insertData(AdminDTO adto) {
		
		PreparedStatement ps =null;
		Connection con = ConnectionFactory.getConnection();
		int res =0;
		
		try {
			
			String sql="insert into admindata(fullname , email, password) value(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, adto.getFullname());
			ps.setString(2, adto.getEmail());
			ps.setString(3, adto.getPassword());
			res = ps.executeUpdate();
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			return res;
		}
		finally {
			ConnectionFactory.closeConnection(ps);
			ConnectionFactory.closeConnection(con);
		}
	}
	
	public ResultSet accessDetail(String email, String password) {
		
		Connection con = ConnectionFactory.getConnection();
		ResultSet resultset = null;
		PreparedStatement ps = null;
		
		try {
			String sql = "select * from admindata where email=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			resultset = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultset;
	}

}
