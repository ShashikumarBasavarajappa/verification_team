package com.verification_team.dao;



import java.util.List;

import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;

public interface RegisterDAO {

	public void insert(Registration registration);
	public Registration login_check(Registration registration);
	public void insert_verification_data(Verification_date verification_data);
	public List<Verification_date> verification_data_list(String username);
	
}
