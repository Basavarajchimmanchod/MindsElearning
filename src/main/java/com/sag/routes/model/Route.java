package com.sag.routes.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/*Model class to create route table in PostgreSQL
 * with routeID source and destination
 * @Entity-Specifies this class is an entity class
 * @Table Specifies Table and the name of table in DB
*/

@Entity
@Table(name = "ROUTE")
public class Route {

	@Id
	//specifies this field is primary key
	@Column(name = "ROUTE_ID")
	//specifies the column 
	private Integer route_id;
	@Column(name = "SOURCE")
	private String source;
	@Column(name = "DESTINATION")
	private String destination;
	
	/*@OneToMany---->specifies one to many relationship with BusRoute_Details
	*@JoinColumn---->to Join routeID(primary key) with BusRoute_Details as foreign Key 
	*@JsonIgnore---->This annotation is to avoid any JSON related errors
	*/
	
	@OneToMany
	@JoinColumn(name = "route_id")
	@JsonIgnore
	private Set<BusRoute_Details> busroutedetails = new HashSet<BusRoute_Details>();

	public Route() {
	}

	public Route(int route_id) {

		this.route_id = route_id;
	}

	public Route(String source, String destination) {

		this.source = source;
		this.destination = destination;
	}
	
	//Getters and Setters
	public Set<BusRoute_Details> getBusroutedetails() {
		return busroutedetails;
	}

	public void setBusroutedetails(Set<BusRoute_Details> busroutedetails) {
		this.busroutedetails = busroutedetails;
	}

	public Integer getRoute_id() {
		return route_id;
	}

	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
