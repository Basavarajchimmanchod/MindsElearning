package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

@Table(name = "Event")
public class Event 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	 @Column
	private int evId;
	 @Column
	private String startDate;
	 @Column
	private String endDate;
	 @Column
	private int studentUserId;
	 @Column
	private int campusId;
	   
	
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public int getEvId() {
		return evId;
	}
	public void setEvId(int evId) {
		this.evId = evId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public int getStudentUserId() {
		return studentUserId;
	}
	public void setStudentUserId(int studentUserId) {
		this.studentUserId = studentUserId;
	}
	public int getCampusId() {
		return campusId;
	}
	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}

}
