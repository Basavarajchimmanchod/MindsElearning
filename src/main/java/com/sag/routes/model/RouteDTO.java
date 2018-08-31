package com.sag.routes.model;

//Simple Model DTO class for Route
 
public class RouteDTO {
	private String source;
	private String destination;
	private String route_Num;

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

	public String getRoute_Num() {
		return route_Num;
	}

	public void setRoute_Num(String route_Num) {
		this.route_Num = route_Num;
	}

	
	@Override
	public String toString() {
		return "RouteDTO [source=" + source + ", destination=" + destination + ", route_Num=" + route_Num + "]";
	}

}
