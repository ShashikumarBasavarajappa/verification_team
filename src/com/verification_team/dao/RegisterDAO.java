package com.verification_team.dao;



import java.util.List;

import com.verification_team.model.OptionEntry;
import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;

public interface RegisterDAO {

	public void insert(Registration registration);
	public Registration login_check(Registration registration);
	public void insert_verification_data(Verification_date verification_data);
	public List<Verification_date> verification_data_list(String username);
	public List<Registration> verification_employees_data_list();
	public List<Verification_date> verification_employees_data_list_data();
	public void delete_verification_data(String cas_id);
	public List<OptionEntry> get_option_set_values(int option_set_id);
	public List<Verification_date> get_data_for_indivisual_portals(String portal_name);

}
