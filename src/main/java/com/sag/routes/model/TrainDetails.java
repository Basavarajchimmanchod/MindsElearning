package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*Model class to create traindetails table in PostgreSQL
 * with trainId,source,destination,time,route
 * @Entity-Specifies this class is an entity class
 * @Table Specifies Table and the name of table in DB
*/

@Entity
@Table(name="TRAINDETAILS")
public class TrainDetails {
		@Id
		//specifies this field is primary key
		private Integer trainId;
		@Column
		//specifies the column 
		private String source;
		@Column
		private String destination;
		@Column
		//Time stored in milliseconds
		private long time;
		@Column
		private String route;
		@Column
		private String type;
		
		
		public TrainDetails() {	}

		
		public TrainDetails(Integer trainId, String source, String destination, long time, String route,String type) {
			this.trainId = trainId;
			this.source = source;
			this.destination = destination;
			this.time = time;
			this.route = route;
			this.type=type;
		}


		//Getter and Setters
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

		public long getTime() {
			return time;
		}


		public void setTime(long time) {
			this.time = time;
		}


		public String getRoute() {
			return route;
		}

		public void setRoute(String route) {
			this.route = route;
		}


		public String getType() {
			return type;
		}


		public void setType(String type) {
			this.type = type;
		}
		
		
}
