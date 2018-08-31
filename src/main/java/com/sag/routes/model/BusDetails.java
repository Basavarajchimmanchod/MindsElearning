package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Model class to create busdetails table in PostgreSQL
 * with busdetailsID and route Number
 * @Entity-Specifies this class is an entity class
 * @Table Specifies Table and the name of table in DB
*/
@Entity
@Table(name = "BUSDETAILS")
public class BusDetails {

	
	@Id
	//specifies this field is primary key
	private Integer busDetails_id;
	@Column
	//specifies the column 
	private String route_Num;

	//Getter and Setters
	public Integer getBusDetails_id() {
		return busDetails_id;
	}

	public void setBusDetails_id(Integer busDetails_id) {
		this.busDetails_id = busDetails_id;
	}

	public String getRoute_Num() {
		return route_Num;
	}

	public void setRoute_Num(String route_Num) {
		this.route_Num = route_Num;
	}

}
