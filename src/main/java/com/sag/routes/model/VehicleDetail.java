package com.sag.routes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "vehicledetails")
public class VehicleDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vdId;
	@Column
	private int Vehicle_no;
	@Column
	private int Vehicle_code;
	@Column
	private String No_of_Seat;
	@Column
	private String Maximum_capacity;
	@Column
	private int insurance;
	@Column
	private int tax_remitted;
	@Column
	private String permit;
	@Column
	private String status;
	@Column
	private String Vehicle_type_id;
	@Column
	private int campusId;
	@Column
	private String GpsNumber;
	
	public String getGpsNumber() {
		return GpsNumber;
	}
	public void setGpsNumber(String gpsNumber) {
		GpsNumber = gpsNumber;
	}
	public int getVdId() {
		return vdId;
	}
	public void setVdId(int vdId) {
		this.vdId = vdId;
	}
	public int getVehicle_no() {
		return Vehicle_no;
	}
	public void setVehicle_no(int vehicle_no) {
		Vehicle_no = vehicle_no;
	}
	public int getVehicle_code() {
		return Vehicle_code;
	}
	public void setVehicle_code(int vehicle_code) {
		Vehicle_code = vehicle_code;
	}
	public String getNo_of_Seat() {
		return No_of_Seat;
	}
	public void setNo_of_Seat(String no_of_Seat) {
		No_of_Seat = no_of_Seat;
	}
	public String getMaximum_capacity() {
		return Maximum_capacity;
	}
	public void setMaximum_capacity(String maximum_capacity) {
		Maximum_capacity = maximum_capacity;
	}
	public int getInsurance() {
		return insurance;
	}
	public void setInsurance(int insurance) {
		this.insurance = insurance;
	}
	public int getTax_remitted() {
		return tax_remitted;
	}
	public void setTax_remitted(int tax_remitted) {
		this.tax_remitted = tax_remitted;
	}
	public String getPermit() {
		return permit;
	}
	public void setPermit(String permit) {
		this.permit = permit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVehicle_type_id() {
		return Vehicle_type_id;
	}
	public void setVehicle_type_id(String vehicle_type_id) {
		Vehicle_type_id = vehicle_type_id;
	}
	public int getCampusId() {
		return campusId;
	}
	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}
	
	
}
