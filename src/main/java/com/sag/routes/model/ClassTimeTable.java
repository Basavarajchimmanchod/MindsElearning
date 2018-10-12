package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "classtimetable")

public class ClassTimeTable 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int TtId;
	 @Column
		private int classId;
	 @Column
		private int weekDayId;
	 @Column
		private int sectionId;
	 @Column
		private String subjectName;
	 @Column
		private Date startTime;
	 @Column
		private Date endTime;
	public int getTtId() {
		return TtId;
	}
	public void setTtId(int ttId) {
		TtId = ttId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getWeekDayId() {
		return weekDayId;
	}
	public void setWeekDayId(int weekDayId) {
		this.weekDayId = weekDayId;
	}
	public int getSectionId() {
		return sectionId;
	}
	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	 
	 
	 
	 
	 
	 
	}
	
