package com.sag.routes.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Assessment")
public class Assessment 
{
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    
    @Column
    private String text;
    
    @Column
    private String points;
 
    @Column
    private String type;
   
    @Column
    private String instructorNotes;
    
    @Column
    private String feedback;
    
    @Column
    private String questions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInstructorNotes() {
		return instructorNotes;
	}

	public void setInstructorNotes(String instructorNotes) {
		this.instructorNotes = instructorNotes;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}
    
    

}