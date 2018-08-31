package com.sag.routes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**Model class to create busroutedetails table in PostgreSQL
 * with composite key busroutedetailsID
 * @Entity-Specifies this class is an entity class
 * @Table Specifies Table and the name of table in DB
*/

@Entity
@Table(name="busroute_Details")
public class BusRoute_Details  {
	/*@EmbeddedId-- To declare the @Embeddable class 
	 * which is the composite key (routeID and BusDetailsID combined as primary Key)
	 * */
	@EmbeddedId
	private BusRoute_DetailsId id;
	
	
	/**@ManyToOne---->specifies many to one relationship with Route and BusDetails
	*@JoinColumn---->to Join routeID(primary key) with BusRoute_Details as foreign Key 
	* & to Join busdetailsID(primary key) with BusRoute_Details as foreign Key 
	*@JsonIgnore---->This annotation is to avoid any JSON related errors
	*/
	
	@ManyToOne
	@JoinColumn(name = "route_id", insertable = false, updatable = false)
    private Route route;
	@ManyToOne
    @JoinColumn(name = "busDetails_id",insertable = false, updatable = false)
    private BusDetails busdetails;
	
	//Getters and Setters
	public void setRoute(Route route) {
		this.route = route;
	}
	public BusRoute_DetailsId getId() {
		return id;
	}
	public void setId(BusRoute_DetailsId id) {
		this.id = id;
	}
	public BusDetails getBusdetails() {
		return busdetails;
	}
	public void setBusdetails(BusDetails busdetails) {
		this.busdetails = busdetails;
	}
	public Route getRoute() {
		return route;
	}
	
	

}
