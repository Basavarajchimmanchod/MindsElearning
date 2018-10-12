package com.sag.routes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="FeeType")

public class FeeDetailClassmap 
{
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feesDetailClassMapId;
	private int feesDetailId;
	private int classId;
	private int sectionId;
	private int amount;
	public int getFeesDetailClassMapId() {
		return feesDetailClassMapId;
	}
	public void setFeesDetailClassMapId(int feesDetailClassMapId) {
		this.feesDetailClassMapId = feesDetailClassMapId;
	}
	public int getFeesDetailId() {
		return feesDetailId;
	}
	public void setFeesDetailId(int feesDetailId) {
		this.feesDetailId = feesDetailId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
