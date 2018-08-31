package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organization")
public class Organization 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	
	private int oId;
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	@Column
	private String name;
	@Column
	private String Type;
	@Column
	private String activated;
	@Column
	private int paid;
	@Column
	private int deleted;
	
	
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getActivated() {
		return activated;
	}
	public void setActivated(String activated) {
		this.activated = activated;
	}
	public int getPaid() {
		return paid;
	}
	public String getName() {
		return name;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
}
