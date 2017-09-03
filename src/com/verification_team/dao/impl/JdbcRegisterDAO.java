package com.verification_team.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


}
