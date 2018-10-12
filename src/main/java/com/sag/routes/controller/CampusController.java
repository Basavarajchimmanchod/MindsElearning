package com.sag.routes.controller;

import java.sql.DriverAction;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sag.routes.model.CampusUser;
import com.sag.routes.model.DriverUser;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.HolidayList;
import com.sag.routes.model.VehicleDetail;
import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/campus")     //sample endpoint--- localhost:8080/rest/campus

public class CampusController 
{
	
		final Logger logger = Logger.getLogger(RouteController.class);

		@Autowired
		private ServiceI serviceI;
		

		// Route Controller
		
		/*
		 * @GetMapping--specifies GET method
		 * @PostMapping--specifies POST method
		 * @PutMapping--specifies PUT method
		 * @DeleteMapping--specifies DELETE method
		 */
		
		@GetMapping("/campus/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<CampusUser> getCampusById(@PathVariable("id") Integer id) {
			CampusUser campus = serviceI.getCampusById(id);
			return new ResponseEntity<CampusUser>(campus, HttpStatus.OK);
		}
		@CrossOrigin
		@GetMapping("/campuses")
		public ResponseEntity<List<CampusUser>> getAllCampuses() {
			List<CampusUser> list = serviceI.getAllCampuses();
			return new ResponseEntity<List<CampusUser>>(list, HttpStatus.OK);
		}

		@PostMapping("/campus")
		public ResponseEntity<Void> addCampus(@RequestBody CampusUser campus, UriComponentsBuilder builder) {
			boolean flag = serviceI.addCampus(campus);
			if (flag == false) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/campus/{id}").buildAndExpand(campus.getCmId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		@PutMapping("/campus")
		public ResponseEntity<CampusUser> updateCampus(@RequestBody CampusUser campus) {
			serviceI.updateCampus(campus);
			return new ResponseEntity<CampusUser>(campus, HttpStatus.OK);
		}

		@DeleteMapping("/campus/{id}")
		public ResponseEntity<Void> deleteCampus(@PathVariable("id") Integer id) {
			serviceI.deleteCampus(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		
		//DriverDetails
		
		
		@GetMapping("/driver/{dId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<DriverUser> getdriverdetailsByID(@PathVariable("dId") Integer dId) {
			DriverUser drivercampus = serviceI.getdriverdetailsByID(dId);
			return new ResponseEntity<DriverUser>(drivercampus, HttpStatus.OK);
		}
		
		
		//DriverDetailsByCampusID
		@GetMapping("/driverCampusId/{campusId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<List<DriverUser>> getdriverdetailsByCampusID(@PathVariable("campusId") Integer campusId) {
			List<DriverUser> drivercampus = serviceI.getdriverdetailsByCampusID(campusId);
			return new ResponseEntity<List<DriverUser>>(drivercampus, HttpStatus.OK);
		}
		
		
		//VehicleDetails
		
		//getVehicleListByCampusId
		
		@GetMapping("/VehicleDetails/{campusId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<List<VehicleDetail>> getVehicleListByCampusId(@PathVariable("campusId") Integer campusId) {
			List<VehicleDetail> vehicle = serviceI.getVehicleListByCampusId(campusId);
			return new ResponseEntity<List<VehicleDetail>>(vehicle, HttpStatus.OK);
		}
		
		//getVehicleListByCampusIdDriverId
		@GetMapping("/VehicleDetails/{campusId}{driverId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<List<VehicleDetail>> getVehicleListByCampusIdDriverId(@PathVariable("campusId") Integer campusId,@PathVariable("DriverId") Integer driverId) {
			List<VehicleDetail> vehicle = serviceI.getVehicleListByCampusIdDriverId(campusId,driverId);
			return new ResponseEntity<List<VehicleDetail>>(vehicle, HttpStatus.OK);
		}
		
		
				//getVehicleRouteAndStopDetailsByVhId
				
				//getStudentVehicleDetailsByStudentAdmNum
		
		
		
		//HolidayList By CampusiD
		@GetMapping("/HolidayDetails/{campusId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<List<HolidayList>> getHolidayListByCampusId(@PathVariable("campusId") Integer campusId) {
			List<HolidayList> holiday = serviceI.getHolidayListByCampusId(campusId);
			return new ResponseEntity<List<HolidayList>>(holiday, HttpStatus.OK);
		}
		
		//Holiday Detials By ID
		@GetMapping("/HolidayDetailsById/{hId}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<HolidayList> getHolidayListById(@PathVariable("hId") Integer hId) {
		HolidayList holiday = serviceI.getHolidayListById(hId);
			return new ResponseEntity<HolidayList>(holiday, HttpStatus.OK);
		}
		
		
		
		
	}

