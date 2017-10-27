package com.verification_team.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.OptionEntry;
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


    	//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	//LocalDate localDate = LocalDate.now();
    	
		DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todaysDate = LocalDate.now();
     
    	
        String str2 = df.format(todaysDate);
        
		String sql = "INSERT INTO VERIFICATION_DATE " +
				"(USERNAME,CAS_ID, START_DATE, END_DATE,APPLICANT_STATUS,NO_OF_TRANSCRIPTS,PORTAL_NAME, created_on) VALUES (?, ?, ?, ?,?,?,?,?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, verification_data.getUsername());
			ps.setString(2, verification_data.getCas_id());
			ps.setString(3, verification_data.getStart_date());
			ps.setString(4, verification_data.getEnd_date());
			ps.setString(5, verification_data.getApplicant_status());
			ps.setString(6, verification_data.getNo_of_transcripts());
			ps.setString(7, verification_data.getPortal_name());
			ps.setString(8, str2);
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
					employee.setNo_of_transcripts(rs.getString("NO_OF_TRANSCRIPTS"));
					employee.setPortal_name(rs.getString("PORTAL_NAME"));
					employee.setCreated_on(rs.getString("created_on"));
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

	@Override
	public List<Registration> verification_employees_data_list() {
		System.out.println("99999999999999999999************ i'm ok inside tht new sub routioner0000000");
		String sql = "SELECT * FROM USERS where USERNAME !='ladmin'";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//Verification_date vv = null;
			List<Registration> vv222 = new ArrayList<Registration>();
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Registration employee = new Registration();
			
					System.out.println("*******ddddd***************" + rs.getString("USERNAME"));
				     employee.setReg_username(rs.getString("USERNAME"));
				vv222.add(employee);
			}
			
			rs.close();
			ps.close();
			System.out.println("******************" + vv222.size());
			return vv222;
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
	public List<Verification_date> verification_employees_data_list_data() {
		String sql = "SELECT * FROM VERIFICATION_DATE";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			//Verification_date vv = null;
			List<Verification_date> vv222 = new ArrayList<Verification_date>();
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Verification_date employee = new Verification_date();
				employee.setUsername(rs.getString("USERNAME"));
				employee.setCas_id(rs.getString("CAS_ID"));
				employee.setStart_date(rs.getString("START_DATE"));
				employee.setEnd_date(rs.getString("END_DATE"));
				employee.setApplicant_status(rs.getString("APPLICANT_STATUS"));
				
				vv222.add(employee);
			}
			
			rs.close();
			ps.close();
			System.out.println("******************" + vv222.size());
			return vv222;
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
	public void delete_verification_data(String cas_id) {
		
							
				String sql = "delete from verification_date where cas_id=?";
				Connection conn = null;
				
				try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, cas_id);
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
	public List<OptionEntry> get_option_set_values(int option_set_id) {
		System.out.println("*********************i'm comming inside===============");
		String sql = "SELECT * FROM OPTIONENTRY where option_set_id = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, option_set_id);
			//Verification_date vv = null;
			List<OptionEntry> vv = new ArrayList<OptionEntry>();
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				OptionEntry employee = new OptionEntry();
			
				employee.setValue_string(rs.getString("VALUE_STRING"));
				employee.setOption_set_id(rs.getInt("OPTION_SET_ID"));
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

	@Override
	public List<Verification_date> get_data_for_indivisual_portals(String portal_name) {
		// TODO Auto-generated method stub
		
		System.out.println("*********************i'm comming inside===============");
		String sql = "SELECT * FROM VERIFICATION_DATE WHERE portal_name = ? order by username asc";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, portal_name);
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
				employee.setNo_of_transcripts(rs.getString("NO_OF_TRANSCRIPTS"));
				employee.setPortal_name(rs.getString("PORTAL_NAME"));;
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

	@Override
	public List<OptionEntry> get_opton_entry_data_portal() {
		// TODO Auto-generated method stub
		return null;
	}

}
