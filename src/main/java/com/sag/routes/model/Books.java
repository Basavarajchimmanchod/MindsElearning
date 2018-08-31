package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity

@Table(name = "Books")
public class Books 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int  id;
@Column
private String ISBN;
@Column
private String Book_title;
@Column
private String date_of_publication;
@Column
private Long bookCount;
@Column
private int campusId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public String getBook_title() {
	return Book_title;
}
public void setBook_title(String book_title) {
	Book_title = book_title;
}
public String getDate_of_publication() {
	return date_of_publication;
}
public void setDate_of_publication(String date_of_publication) {
	this.date_of_publication = date_of_publication;
}
public Long getBookCount() {
	return bookCount;
}
public void setBookCount(Long bookCount) {
	this.bookCount = bookCount;
}
public int getCampusId() {
	return campusId;
}
public void setCampusId(int campusId) {
	this.campusId = campusId;
}



}
