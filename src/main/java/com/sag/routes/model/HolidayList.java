package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Holidays")
public class HolidayList
{
	 @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	   private int hId;
	    @Column
	    private String holidayName;
	   
	    public int gethId() {
			return hId;
		}
		public void sethId(int hId) {
			this.hId = hId;
		}
		public String getHolidayName() {
			return holidayName;
		}
		public void setHolidayName(String holidayName) {
			this.holidayName = holidayName;
		}
		public String getHolidayDesc() {
			return holidayDesc;
		}
		public void setHolidayDesc(String holidayDesc) {
			this.holidayDesc = holidayDesc;
		}
		public String getCampusId() {
			return campusId;
		}
		public void setCampusId(String campusId) {
			this.campusId = campusId;
		}
		public String getMessageFlag() {
			return messageFlag;
		}
		public void setMessageFlag(String messageFlag) {
			this.messageFlag = messageFlag;
		}
		public String getHolidayStartDate() {
			return holidayStartDate;
		}
		public void setHolidayStartDate(String holidayStartDate) {
			this.holidayStartDate = holidayStartDate;
		}
		public String getHolidayEndDate() {
			return holidayEndDate;
		}
		public void setHolidayEndDate(String holidayEndDate) {
			this.holidayEndDate = holidayEndDate;
		}
		@Column
	    private String holidayDesc;
	    @Column
	    private String campusId;
	    @Column
	    private String messageFlag;
	    @Column
	    private String holidayStartDate;
	    @Column
	    private String holidayEndDate;
	    
	    
	    
	    
	    
}
