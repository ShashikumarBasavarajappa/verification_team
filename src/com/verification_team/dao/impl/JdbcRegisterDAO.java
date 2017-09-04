package com.verification_team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;

public class JdbcRegisterDAO  implements RegisterDAO{

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Registration registration) {
		System.out.println("=====================" + registration.getReg_email());
		String sql = "INSERT INTO USERS " +
				"(USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, registration.getReg_username());
			ps.setString(2, registration.getReg_password());
			ps.setString(3, registration.getReg_email());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	@Override
	public Registration login_check(Registration registration) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM USERS WHERE  USERNAME = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, registration.getReg_username());
			Registration reg = null;
			ResultSet rs = ps.executeQuery();
			//System.out.println("=============AMMA ====== " + rs.getString("USERNAME") );
		
			while (rs.next()) {
				reg = new Registration(
						rs.getString("USERNAME"),
						rs.getString("PASSWORD")
				);
			}
		
			rs.close();
			ps.close();
			return reg;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	@Override
	public void insert_verification_data(Verification_date verification_data) {
		// TODO Auto-generated method stub
                           																																														
		String sql = "INSERT INTO VERIFICATION_DATE " +
				"(USERNAME,CAS_ID, START_DATE, END_DATE,APPLICANT_STATUS) VALUES (?,?, ?, ?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, verification_data.getUsername());
			ps.setString(2, verification_data.getCas_id());
			ps.setString(3, verification_data.getStart_date());
			ps.setString(4, verification_data.getEnd_date());
			ps.setString(5, verification_data.getApplicant_status());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

     	} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}

	}

	@Override
	public List<Verification_date> verification_data_list(String username) {
		// TODO Auto-generated method stub
			
		System.out.println("*********************i'm comming inside===============");
			String sql = "SELECT * FROM VERIFICATION_DATE WHERE USERNAME = ?";
			
			Connection conn = null;
			
			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				//Verification_date vv = null;
				List<Verification_date> vv = new ArrayList<Verification_date>();
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					
					Verification_date employee = new Verification_date();
				
					employee.setUsername(rs.getString("USERNAME"));
					employee.setCas_id(rs.getString("CAS_ID"));
					employee.setStart_date(rs.getString("START_DATE"));
					employee.setEnd_date(rs.getString("END_DATE"));
					employee.setApplicant_status(rs.getString("APPLICANT_STATUS"));
					vv.add(employee);
					/*
					 vv =   new Verification_date(
							rs.getString("USERNAME"),
							rs.getString("CAS_ID"), 
							rs.getString("START_DATE"),
							rs.getString("END_DATE"),
							rs.getString("APPLICANT_STATUS") 
					);
					*/
				}
				
				rs.close();
				ps.close();
				System.out.println("******************" + vv.size());
				return vv;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
					conn.close();
					} catch (SQLException e) {}
				}
			}
		}

}
