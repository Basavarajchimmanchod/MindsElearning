package com.sag.routes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Feesdetail")

public class Fees
{
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feeDetailId;
	private String feeDetailName;
	private int campusId;
	public int getFeeDetailId() {
		return feeDetailId;
	}
	public void setFeeDetailId(int feeDetailId) {
		this.feeDetailId = feeDetailId;
	}
	public String getFeeDetailName() {
		return feeDetailName;
	}
	public void setFeeDetailName(String feeDetailName) {
		this.feeDetailName = feeDetailName;
	}
	public int getCampusId() {
		return campusId;
	}
	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}
	
	
}
