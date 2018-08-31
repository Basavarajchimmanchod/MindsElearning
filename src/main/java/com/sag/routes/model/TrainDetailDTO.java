package com.sag.routes.model;

public class TrainDetailDTO {
	
	private Integer trainId;
	private String source;
	private String destination;
	private String route;
	private String time;
	private String type;
	
	
	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
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
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	//TimeUnit.MILLISECONDS.toHours(millis),
	//TimeUnit.MILLISECONDS.toMinutes(millis) -  
	//TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),	
}

