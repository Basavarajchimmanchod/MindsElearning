package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CLASS")
public class Class {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 @Column
	private String campus_id;
	 @Column
	private String term_id;
	 @Column
	private String class_name;
	 @Column
	private int deleted;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCampus_id() {
		return campus_id;
	}
	public void setCampus_id(String campus_id) {
		this.campus_id = campus_id;
	}
	public String getTerm_id() {
		return term_id;
	}
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
}
