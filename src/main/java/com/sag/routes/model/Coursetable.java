package com.sag.routes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSETABLE")
public class Coursetable

{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
	 @Column
   private int courseId;
	 @Column
   private String name; 
	 @Column
   private String description;
	 @Column
   private String organization;
	 @Column
   private String readOnly;
	 @Column
   private String termId;
	 @Column
   private String availibility;
	 @Column
   private String enrollment;
	 @Column
   private String dataSourceId;
	 @Column
   private String externalId;
	 @Column
   private Date created;
	 @Column
   private String allowGuests;
	 

public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getOrganization() {
	return organization;
}
public void setOrganization(String organization) {
	this.organization = organization;
}
public String getReadOnly() {
	return readOnly;
}
public void setReadOnly(String readOnly) {
	this.readOnly = readOnly;
}
public String getTermId() {
	return termId;
}
public void setTermId(String termId) {
	this.termId = termId;
}
public String getAvailibility() {
	return availibility;
}
public void setAvailibility(String availibility) {
	this.availibility = availibility;
}
public String getEnrollment() {
	return enrollment;
}
public void setEnrollment(String enrollment) {
	this.enrollment = enrollment;
}
public String getDataSourceId() {
	return dataSourceId;
}
public void setDataSourceId(String dataSourceId) {
	this.dataSourceId = dataSourceId;
}
public String getExternalId() {
	return externalId;
}
public void setExternalId(String externalId) {
	this.externalId = externalId;
}
public Date getCreated() {
	return created;
}
public void setCreated(Date created) {
	this.created = created;
}
public String getAllowGuests() {
	return allowGuests;
}
public void setAllowGuests(String allowGuests) {
	this.allowGuests = allowGuests;
}
   

}
