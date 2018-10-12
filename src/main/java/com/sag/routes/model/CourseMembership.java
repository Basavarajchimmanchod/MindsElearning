package com.sag.routes.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSEMEMBERSHIP")
public class CourseMembership 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sdId;
    @Column
    private int courseId;
    @Column
    private int datasourceId;
    @Column
    private Date created;
    @Column
    private Date avaliability;
    @Column
    private Date lastAccessed;
	public int getSdId() {
		return sdId;
	}
	public void setSdId(int sdId) {
		this.sdId = sdId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getDatasourceId() {
		return datasourceId;
	}
	public void setDatasourceId(int datasourceId) {
		this.datasourceId = datasourceId;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getAvaliability() {
		return avaliability;
	}
	public void setAvaliability(Date avaliability) {
		this.avaliability = avaliability;
	}
	public Date getLastAccessed() {
		return lastAccessed;
	}
	public void setLastAccessed(Date lastAccessed) {
		this.lastAccessed = lastAccessed;
	}
    
	
}
