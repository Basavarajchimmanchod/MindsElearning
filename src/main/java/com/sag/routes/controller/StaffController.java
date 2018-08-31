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


/*import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;*/
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/staff")     //sample endpoint--- localhost:8080/rest/bus
public class StaffController {

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
	
	@GetMapping("/staff/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<Staff> getstaffById(@PathVariable("id") Integer id) {
		Staff staff = serviceI.getstaffById(id);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/staffs")
	public ResponseEntity<List<Staff>> getAllstaffs() {
		List<Staff> list = serviceI.getAllstaffs();
		return new ResponseEntity<List<Staff>>(list, HttpStatus.OK);
	}

	@PostMapping("/staff")
	public ResponseEntity<Void> addstaff(@RequestBody Staff staff, UriComponentsBuilder builder) {
		boolean flag = serviceI.addstaff(staff);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/staff/{id}").buildAndExpand(staff.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/staff")
	public ResponseEntity<Staff> updatestaff(@RequestBody Staff staff) {
		serviceI.updatestaff(staff);
		return new ResponseEntity<Staff>(staff, HttpStatus.OK);
	}

	@DeleteMapping("/staff/{staffid}")
	public ResponseEntity<Void> deletestaff(@PathVariable("staffid") Integer id) {
		serviceI.deletestaff(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	//getStaffUserListByCampusId
	
	@GetMapping("getStaffUserListByClassId/{classId}")
	  public ResponseEntity<List<Staff>> getStaffUserListByClassId(@PathVariable("classId") Integer classId) 
		 {
			 List< Staff> staff = serviceI.getStaffUserListByClassId(classId);
			 return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);
		       
		  }
	////getStaffUserListBycampusId
	@GetMapping("getStaffUserListByCampusId/{campusId}")
	  public ResponseEntity<List<Staff>> getStaffUserListBycampusId(@PathVariable("campusId") Integer campusId) 
		 {
			List< Staff >staff = serviceI.getStaffUserListByCampusId(campusId);
			 return new ResponseEntity<List<Staff>>(staff, HttpStatus.OK);
		       
		  }
	
	
	}
