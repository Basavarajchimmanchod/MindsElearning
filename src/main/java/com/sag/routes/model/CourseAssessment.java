package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "COURSEASSESSMENT")
public class CourseAssessment

{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int courseId;
	
	@Column
    private int assessmentId;
	
	@Column
    private String title;
	
	@Column
    private String points;
	
	@Column
    private String instructorNotes;
	
	@Column
    private String type;

	public long getCourseId() {
		return courseId;
	}

	

	public int getAssessmentId() {
		return assessmentId;
	}



	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}



	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getInstructorNotes() {
		return instructorNotes;
	}

	public void setInstructorNotes(String instructorNotes) {
		this.instructorNotes = instructorNotes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
