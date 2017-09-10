package com.verification_team.model;

public class OptionEntry {

String value_string;
int option_set_id;
	public String getValue_string() {
	return value_string;
	}
public void setValue_string(String value_string) {
	this.value_string = value_string;
}
public int getOption_set_id() {
	return option_set_id;
}
public void setOption_set_id(int option_set_id) {
	this.option_set_id = option_set_id;
}

public OptionEntry() {
	// TODO Auto-generated constructor stub
}

public OptionEntry(String value_string,int  option_set_id){
	this.value_string = value_string;
	this.option_set_id = option_set_id;
}
	@Override
	public String toString() {
		return "Option_entry [value_string=" + value_string +  ", option_set_id=" + option_set_id +" ]";
}
	
}
