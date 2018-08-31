package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SCHOOL_LOGO")
public class School 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column
	private String Photo_file_name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhoto_file_name() {
		return Photo_file_name;
	}
	public void setPhoto_file_name(String photo_file_name) {
		Photo_file_name = photo_file_name;
	}
	public String getPhoto_Content_Type() {
		return Photo_Content_Type;
	}
	public void setPhoto_Content_Type(String photo_Content_Type) {
		Photo_Content_Type = photo_Content_Type;
	}
	public int getPhoto_file_Size() {
		return Photo_file_Size;
	}
	public void setPhoto_file_Size(int photo_file_Size) {
		Photo_file_Size = photo_file_Size;
	}
	public String getPhoto_data_blob() {
		return Photo_data_blob;
	}
	public void setPhoto_data_blob(String photo_data_blob) {
		Photo_data_blob = photo_data_blob;
	}
	public int getCampus_ID() {
		return Campus_ID;
	}
	public void setCampus_ID(int campus_ID) {
		Campus_ID = campus_ID;
	}
	public int getHolidayId() {
		return holidayId;
	}
	public void setHolidayId(int holidayId) {
		this.holidayId = holidayId;
	}
	@Column
	private String Photo_Content_Type;
	@Column
	private int Photo_file_Size;
	@Column
	private String Photo_data_blob;
	@Column
	private int Campus_ID;
	@Column
	private int holidayId;
	
}
