package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ATTENDANCE")
public class AttendanceUser 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private int stud_id;
    @Column
    private String Studentadminno;
    @Column
    private String Firstname;
    @Column
    private String remark;
    @Column
    private String status;
    @Column
    private String DOI;
    @Column
    private String updatedon;
    @Column
    private String className;
    @Column
    private String campusName;
    
    @Column
    private String staffUserId;
    
    @Column
    private String orgName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public int getStud_id() {
		return stud_id;
	}

	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	public String getStudentadminno() {
		return Studentadminno;
	}

	public void setStudentadminno(String studentadminno) {
		Studentadminno = studentadminno;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDOI() {
		return DOI;
	}

	public void setDOI(String dOI) {
		DOI = dOI;
	}

	public String getUpdatedon() {
		return updatedon;
	}

	public void setUpdatedon(String updatedon) {
		this.updatedon = updatedon;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
 
    

}