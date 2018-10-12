package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity

	@Table(name = "COURSEGRADES")
	public class CourseGrades {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int courseId;
	    
	    @Column
	    private String name;
	    
	    @Column
	    private String description;
	    
	    @Column
	    private String externalGrade;
	    
	    @Column
	    private String contentId;
	    
	    @Column
	    private String score;
	    
	    @Column
	    private String gradingtype;
	    
	    public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getExternalGrade() {
			return externalGrade;
		}

		public void setExternalGrade(String externalGrade) {
			this.externalGrade = externalGrade;
		}

		public String getContentId() {
			return contentId;
		}

		public void setContentId(String contentId) {
			this.contentId = contentId;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		public String getGradingtype() {
			return gradingtype;
		}

		public void setGradingtype(String gradingtype) {
			this.gradingtype = gradingtype;
		}

		public String getGradingdue() {
			return gradingdue;
		}

		public void setGradingdue(String gradingdue) {
			this.gradingdue = gradingdue;
		}

		public String getGradingattemptsAllowed() {
			return gradingattemptsAllowed;
		}

		public void setGradingattemptsAllowed(String gradingattemptsAllowed) {
			this.gradingattemptsAllowed = gradingattemptsAllowed;
		}

		@Column
	    private String gradingdue;
	    
	    @Column
	    private String  gradingattemptsAllowed;
	    
}

