package com.sag.routes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="FeeType")


	
public class FeeType 
{
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feeTypeId;
	private String feeTypeName;
	private int feecount;
	private int campusId;
	public int getFeecount() {
		return feecount;
	}
	public void setFeecount(int feecount) {
		this.feecount = feecount;
	}
	public int getFeeTypeId() {
		return feeTypeId;
	}
	public void setFeeTypeId(int feeTypeId) {
		this.feeTypeId = feeTypeId;
	}
	public String getFeeTypeName() {
		return feeTypeName;
	}
	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}
	
	public int getCampusId() {
		return campusId;
	}
	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}
	
}


