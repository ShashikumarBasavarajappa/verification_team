package com.verification_team.model;

public class Verification_date {
	
	String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	String cas_id;
	String start_date;
	String end_date;
	String applicant_status;
	
	public Verification_date() {
		// TODO Auto-generated constructor stub
	}
	
	public Verification_date(String username,  String cas_id, String start_date,String end_date,String applicant_status ){
		this.username = username;
		this.cas_id = cas_id;
		this.start_date =  start_date;
		this.end_date = end_date;
		this.applicant_status = applicant_status;
	}
	public String getCas_id() {
		return cas_id;
	}
	public void setCas_id(String cas_id) {
		this.cas_id = cas_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getApplicant_status() {
		return applicant_status;
	}
	public void setApplicant_status(String applicant_status) {
		this.applicant_status = applicant_status;
	}	
	
	@Override
	public String toString() {
		return "Verification_date [username=" + username +  ", cas_id=" + cas_id +  ", start_date=" + start_date +  ", end_date=" + end_date + ", applicant_status=" + applicant_status  
				+ "]";
	}
}