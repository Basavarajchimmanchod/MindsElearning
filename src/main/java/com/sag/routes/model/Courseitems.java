package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "Courseitems")
public class Courseitems 

{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
	
	private String type;
	private int calendarId;
	
	private String calendarName;
	private String title;
	private String description;
	private String location;
	private Date start;
	private Date end;
	private Date modified;
	private String color;
	private String categoryId;
	private String eventtype;
    private String frequency;
    private String interval;
    private String  monthRepeatday;
    
    
}
