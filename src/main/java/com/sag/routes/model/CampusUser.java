package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CAMPUS")
public class CampusUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int cmId;
	@Column	
private String campus_name;
	@Column
private String campusAddress;
	@Column
private String campusLocation;
	@Column
private int organization_id;
	@Column
private int organizationName;

public int getCmId() {
		return cmId;
	}
	public void setCmId(int cmId) {
		this.cmId = cmId;
	}
public String getCampus_name() {
	return campus_name;
}
public void setCampus_name(String campus_name) {
	this.campus_name = campus_name;
}
public String getCampusAddress() {
	return campusAddress;
}
public void setCampusAddress(String campusAddress) {
	this.campusAddress = campusAddress;
}
public String getCampusLocation() {
	return campusLocation;
}
public void setCampusLocation(String campusLocation) {
	this.campusLocation = campusLocation;
}
public int getOrganization_id() {
	return organization_id;
}
public void setOrganization_id(int organization_id) {
	this.organization_id = organization_id;
}
public int getOrganizationName() {
	return organizationName;
}
public void setOrganizationName(int organizationName) {
	this.organizationName = organizationName;
}

}
