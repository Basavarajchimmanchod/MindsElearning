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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/medicaldetails") 
public class MedicalDetailsController 
{

	final static Logger logger = Logger.getLogger(com.sag.routes.model.MedicalDetails.class);

	@Autowired
	private ServiceI serviceI;
	

	// Route Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/medicaldetails/{mid}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<com.sag.routes.model.MedicalDetails> getMedicalDetailsById(@PathVariable("mid") Integer mid) {
		com.sag.routes.model.MedicalDetails medicaldetails = serviceI.getMedicalDetailsById(mid);
		return new ResponseEntity<com.sag.routes.model.MedicalDetails>(medicaldetails , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/getmedicaldetails")
	public ResponseEntity<List<com.sag.routes.model.MedicalDetails>> getMedicalDetails() {
		List<com.sag.routes.model.MedicalDetails> medicalList = serviceI.getMedicalDetails();
		return new ResponseEntity<List<com.sag.routes.model.MedicalDetails>>(medicalList, HttpStatus.OK);
	}

	@PostMapping("/Addmedicaldetails")
	public ResponseEntity<Void> addMedicalDetails(@RequestBody com.sag.routes.model.MedicalDetails medical, UriComponentsBuilder builder) {
		boolean flag = serviceI.addMedicalDetails(medical);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/medicalDetails/{mid}").buildAndExpand(medical.getMid()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/updatemedicaldetails")
	public ResponseEntity<com.sag.routes.model.MedicalDetails> updateMedical(@RequestBody com.sag.routes.model.MedicalDetails medical) {
		serviceI.updateMedical(medical);
		return new ResponseEntity<com.sag.routes.model.MedicalDetails>(medical, HttpStatus.OK);
	}

	@DeleteMapping("/deletemedicaldetails/{id}")
	public ResponseEntity<Void> deleteMedical(@PathVariable("id") Integer id) {
		serviceI.deleteMedical(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
}
