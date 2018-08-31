package com.sag.routes.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/bus")     //sample endpoint--- localhost:8080/rest/bus
public class RouteController {

	final static Logger logger = Logger.getLogger(RouteController.class);

	@Autowired
	private ServiceI serviceI;
	

	// Route Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/routes/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<Route> getRouteById(@PathVariable("id") Integer id) {
		Route route = serviceI.getRouteById(id);
		return new ResponseEntity<Route>(route, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRoutes() {
		List<Route> list = serviceI.getAllRoutes();
		return new ResponseEntity<List<Route>>(list, HttpStatus.OK);
	}

	@PostMapping("/route")
	public ResponseEntity<Void> addRoute(@RequestBody Route route, UriComponentsBuilder builder) {
		boolean flag = serviceI.addRoute(route);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/route/{id}").buildAndExpand(route.getRoute_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/route")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
		serviceI.updateRoute(route);
		return new ResponseEntity<Route>(route, HttpStatus.OK);
	}

	@DeleteMapping("/route/{routeid}")
	public ResponseEntity<Void> deleteRoute(@PathVariable("routeid") Integer id) {
		serviceI.deleteRoute(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@GetMapping("/routenumbers") // eg:/routenumber?source=velachery&destination=madipakkam
	public List<RouteDTO> getBusRoute(@RequestParam(value = "source", required = true) String source,
			@RequestParam(value = "destination", required = false) String destination) {
		List<RouteDTO> route = serviceI.getBusRoute(source, destination);
		logger.info(source + destination);
		return route;

	}

	// Bus Controller

	@GetMapping("/busdetails/{id}")   //sample endpoint---- localhost:8080/rest/bus/busdetails/{id}
	public ResponseEntity<BusDetails> getBusDetailsById(@PathVariable("id") Integer id) {
		BusDetails busDetails = serviceI.getBusDetailsById(id);
		return new ResponseEntity<BusDetails>(busDetails, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/busdetails")
	public ResponseEntity<List<BusDetails>> getAllBusDetails() {
		List<BusDetails> list = serviceI.getAllBusDetails();
		return new ResponseEntity<List<BusDetails>>(list, HttpStatus.OK);
	}

	@PostMapping("/createbusdetails")
	public ResponseEntity<Void> addBusDetails(@RequestBody BusDetails busDetails, UriComponentsBuilder builder) {
		boolean flag = serviceI.addBusDetails(busDetails);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/busdetails/{id}").buildAndExpand(busDetails.getBusDetails_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<BusDetails> updateBusDetails(@RequestBody BusDetails busDetails) {
		serviceI.updateBusDetails(busDetails);
		return new ResponseEntity<BusDetails>(busDetails, HttpStatus.OK);
	}

	@DeleteMapping("/deletebusdetails/{id}")
	public ResponseEntity<Void> deleteBusDetails(@PathVariable("id") Integer id) {
		serviceI.deleteBusDetails(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	}
