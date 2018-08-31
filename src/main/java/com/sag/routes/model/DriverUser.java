package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DRIVER_DETAILS")
public class DriverUser 
{
        @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int dId;
	    @Column
	    private String DLno;
	    @Column
	    private int user_id;
	    @Column
	    private int vehicleId;
	    @Column
	    private String documentsSubmitted;
	    @Column
	    private int religionId;
	    @Column
	    private int motherTongueId;
	    @Column
	    private int categoryId;
	    @Column
	    private int nationalityId;
		public long getdId() {
			return dId;
		}
		
		public void setdId(int dId) {
			this.dId = dId;
		}

		public void setDLno(String dLno) {
			DLno = dLno;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getVehicleId() {
			return vehicleId;
		}
		public void setVehicleId(int vehicleId) {
			this.vehicleId = vehicleId;
		}
		public String getDocumentsSubmitted() {
			return documentsSubmitted;
		}
		public void setDocumentsSubmitted(String documentsSubmitted) {
			this.documentsSubmitted = documentsSubmitted;
		}
		public int getReligionId() {
			return religionId;
		}
		public void setReligionId(int religionId) {
			this.religionId = religionId;
		}
		public int getMotherTongueId() {
			return motherTongueId;
		}
		public void setMotherTongueId(int motherTongueId) {
			this.motherTongueId = motherTongueId;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		public int getNationalityId() {
			return nationalityId;
		}
		public void setNationalityId(int nationalityId) {
			this.nationalityId = nationalityId;
		}
	}
	
	
	    /*@Column
	    private String Deleted;
	    @Column
	    private String context;*/
	    /*@Column
	    private String user_id;
	    @Column
	    private String phoneNumber;
	    @Column
	    private String DLno;
	    @Column
	    private String vehicleid;
	    @Column
	    private String campusId;
	    @Column
	    private String campusName;
	    @Column
	    private String orgId;
	    @Column
	    private String orgName;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getMiddleName() {
			return middleName;
		}
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getDeleted() {
			return Deleted;
		}
		public void setDeleted(String deleted) {
			Deleted = deleted;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getDLno() {
			return DLno;
		}
		public void setDLno(String dLno) {
			DLno = dLno;
		}
		public String getVehicleid() {
			return vehicleid;
		}
		public void setVehicleid(String vehicleid) {
			this.vehicleid = vehicleid;
		}
		public String getCampusId() {
			return campusId;
		}
		public void setCampusId(String campusId) {
			this.campusId = campusId;
		}
		public String getCampusName() {
			return campusName;
		}
		public void setCampusName(String campusName) {
			this.campusName = campusName;
		}
		public String getOrgId() {
			return orgId;
		}
		public void setOrgId(String orgId) {
			this.orgId = orgId;
		}
		public String getOrgName() {
			return orgName;
		}
		public void setOrgName(String orgName) {
			this.orgName = orgName;
		}
	    
	}
*/
		
