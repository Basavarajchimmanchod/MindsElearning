package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Medical_Details")
public class MedicalDetails 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int mid;
	 @Column
	 private int user_id;
	 @Column
	 private String Bloodgroup;
	 @Column
	 private int ailment;
	 @Column
	 private String Doctorname;
	 @Column
	 private String Doctor_address;
	 @Column
	 private String Mobile;
	 
	 
	

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
	public String getBloodgroup() {
		return Bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		Bloodgroup = bloodgroup;
	}

	public int getAilment() {
		return ailment;
	}

	public void setAilment(int ailment) {
		this.ailment = ailment;
	}

	

	public String getDoctorname() {
		return Doctorname;
	}

	public void setDoctorname(String doctorname) {
		Doctorname = doctorname;
	}

	public String getDoctor_address() {
		return Doctor_address;
	}

	public void setDoctor_address(String doctor_address) {
		Doctor_address = doctor_address;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	
	 
	 
	 
}
