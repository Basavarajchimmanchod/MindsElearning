package com.sag.routes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

//Simple Model Class with @Embeddable Annotation

/**@Embeddable is used to create composite key for the
 * table BusRouteDetails ,BusRoute_DetailsId contains the two 
 * primary key of Route and Busdetails  
 */

@Embeddable
public class BusRoute_DetailsId implements Serializable{
	
	private static final long serialVersionUID = -9182576832636677286L;
	@Column(name="route_id")
	private Integer route_id;
	@Column(name="busDetails_id")
	private Integer busDetails_id;
	
	public BusRoute_DetailsId(){
		
	}
	
	public BusRoute_DetailsId(Integer route_id, Integer busDetails_id) {
		this.route_id = route_id;
		this.busDetails_id = busDetails_id;
	}
	//Getters and Setters
	public Integer getRoute_id() {
		return route_id;
	}

	public void setRoute_id(Integer route_id) {
		this.route_id = route_id;
	}

	public Integer getBusDetails_id() {
		return busDetails_id;
	}

	public void setBusDetails_id(Integer busDetails_id) {
		this.busDetails_id = busDetails_id;
	}
	
	//HashCode and Equals Methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((busDetails_id == null) ? 0 : busDetails_id.hashCode());
		result = prime * result + ((route_id == null) ? 0 : route_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusRoute_DetailsId other = (BusRoute_DetailsId) obj;
		if (busDetails_id == null) {
			if (other.busDetails_id != null)
				return false;
		} else if (!busDetails_id.equals(other.busDetails_id))
			return false;
		if (route_id == null) {
			if (other.route_id != null)
				return false;
		} else if (!route_id.equals(other.route_id))
			return false;
		return true;
	}
	

}
