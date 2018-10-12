package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schoolnews") 
public class SchoolNews 
{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	 @Column
	 private int schoolId;
	 @Column
	 private int headlines;
	 @Column
	 private String newsdesc;
	 @Column
	 private Date newsdate;
	 @Column
	 private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public int getHeadlines() {
		return headlines;
	}
	public void setHeadlines(int headlines) {
		this.headlines = headlines;
	}
	public String getNewsdesc() {
		return newsdesc;
	}
	public void setNewsdesc(String newsdesc) {
		this.newsdesc = newsdesc;
	}
	public Date getNewsdate() {
		return newsdate;
	}
	public void setNewsdate(Date newsdate) {
		this.newsdate = newsdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	 
}
