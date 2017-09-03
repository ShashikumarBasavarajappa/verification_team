package com.verification_team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.Registration;

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
		
			if (rs.next()) {
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
}
