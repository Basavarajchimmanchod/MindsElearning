package com.sag.routes.model;

public class BookIssue 
{
private int id;
private Long stdUserId;
private int bookid;
private String date_issued;
private String date_due_for_return;
private String date_returned;
private int amount_of_fine;
private Long libUserId;
private Long libRetId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Long getStdUserId() {
	return stdUserId;
}
public void setStdUserId(Long stdUserId) {
	this.stdUserId = stdUserId;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getDate_issued() {
	return date_issued;
}
public void setDate_issued(String date_issued) {
	this.date_issued = date_issued;
}
public String getDate_due_for_return() {
	return date_due_for_return;
}
public void setDate_due_for_return(String date_due_for_return) {
	this.date_due_for_return = date_due_for_return;
}
public String getDate_returned() {
	return date_returned;
}
public void setDate_returned(String date_returned) {
	this.date_returned = date_returned;
}
public int getAmount_of_fine() {
	return amount_of_fine;
}
public void setAmount_of_fine(int amount_of_fine) {
	this.amount_of_fine = amount_of_fine;
}
public Long getLibUserId() {
	return libUserId;
}
public void setLibUserId(Long libUserId) {
	this.libUserId = libUserId;
}
public Long getLibRetId() {
	return libRetId;
}
public void setLibRetId(Long libRetId) {
	this.libRetId = libRetId;
}


}
