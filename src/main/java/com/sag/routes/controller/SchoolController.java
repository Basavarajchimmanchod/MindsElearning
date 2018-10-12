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




import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.LibrarianUser;
import com.sag.routes.model.School;
/*import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;*/
import com.sag.routes.model.Student;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/school")     //sample endpoint--- localhost:8080/rest/bus
public class SchoolController {

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
	
	@GetMapping("/school/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<School> getSchoolById(@PathVariable("id") Integer id) {
		School school = serviceI.getSchoolById(id);
		return new ResponseEntity<School>(school , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/schools")
	public ResponseEntity<List<School>> getAllSchool() {
		List<School> list = serviceI.getAllSchool();
		return new ResponseEntity<List<School>>(list, HttpStatus.OK);
	}

	@PostMapping("/schools")
	public ResponseEntity<Void> addSchool(@RequestBody School school, UriComponentsBuilder builder) {
		boolean flag = serviceI.addSchool(school);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/school/{id}").buildAndExpand(school.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/school")
	public ResponseEntity<School> updateSchool(@RequestBody School school) {
		serviceI.updateSchool(school);
		return new ResponseEntity<School>(school, HttpStatus.OK);
	}

	@DeleteMapping("/school/{id}")
	public ResponseEntity<Void> deleteSchool(@PathVariable("id") Integer id) {
		serviceI.deleteSchool(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//getSchoolNewsListBySchoolId
	public ResponseEntity<Void> getSchoolNewsListBySchoolId(@PathVariable("id") Integer id) {
		serviceI.getSchoolNewsListBySchoolId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	//getSchoolListByCampusId
	public ResponseEntity<Void> getSchoolListByCampusId(@PathVariable("id") Integer id) {
		serviceI.getSchoolListByCampusId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	}
