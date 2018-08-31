package com.sag.routes.model;

import javax.persistence.Column;

public class UserContext 
{
	@Column
private int id;
	@Column
private int userId;
	@Column
private int contextId;
	@Column
private int campusId;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public int getContextId() {
	return contextId;
}
public void setContextId(int contextId) {
	this.contextId = contextId;
}
public int getCampusId() {
	return campusId;
}
public void setCampusId(int campusId) {
	this.campusId = campusId;
}
}
