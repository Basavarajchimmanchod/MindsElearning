package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

     @Entity
	@Table(name = "Login")
	public class Login {

	    public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		@Id
	    @GeneratedValue(strategy= GenerationType.AUTO)
	    private int id;
	    @Column
	    private String username;
	    @Column
	    @JsonIgnore
	    private String password;
}

