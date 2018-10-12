package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "Examtimetable")
public class ExamDetails
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EttId;
	 @Column
	private int subId;
	 @Column
	private String ecmapId;
	 @Column
	private String examDate;
	 @Column
	private int fromTime;
	 @Column
	private int toTime;
	 @Column
   private int status;
	 
	 @Column
		private Date createdAt;
	 
	 @Column
	private Date updatedAt;
	public int getEttId() {
		return EttId;
	}
	public void setEttId(int ettId) {
		EttId = ettId;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getEcmapId() {
		return ecmapId;
	}
	public void setEcmapId(String ecmapId) {
		this.ecmapId = ecmapId;
	}
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	public int getFromTime() {
		return fromTime;
	}
	public void setFromTime(int fromTime) {
		this.fromTime = fromTime;
	}
	public int getToTime() {
		return toTime;
	}
	public void setToTime(int toTime) {
		this.toTime = toTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}
