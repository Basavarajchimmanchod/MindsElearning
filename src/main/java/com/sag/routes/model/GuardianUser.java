package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Guardian")
public class GuardianUser 
{
         @Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int gId;
	    @Column
	    private int user_id;
	    @Column
	    private String relationship;
	    @Column
	    private String mobile;
	    @Column
	    private String income;
	    @Column
	    private String education;
	    @Column
	    private String occupation;
	    @Column
	    private String stdadmissionno;
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
	    /*@Column
	    private String mobile;
	    @Column
	    private String income;
	    @Column
	    private String education;
	    @Column
	    private String stdadmissionno;
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
		public String getRelationship() {
			return relationship;
		}
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getStdadmissionno() {
			return stdadmissionno;
		}
		public void setStdadmissionno(String stdadmissionno) {
			this.stdadmissionno = stdadmissionno;
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
		}*/
		public int getgId() {
			return gId;
		}
		public void setgId(int gId) {
			this.gId = gId;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getRelationship() {
			return relationship;
		}
		public void setRelationship(String relationship) {
			this.relationship = relationship;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getIncome() {
			return income;
		}
		public void setIncome(String income) {
			this.income = income;
		}
		public String getEducation() {
			return education;
		}
		public void setEducation(String education) {
			this.education = education;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getStdadmissionno() {
			return stdadmissionno;
		}
		public void setStdadmissionno(String stdadmissionno) {
			this.stdadmissionno = stdadmissionno;
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
