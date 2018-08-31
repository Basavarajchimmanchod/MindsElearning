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

import com.sag.routes.model.Class;
import com.sag.routes.service.ServiceI;



@RestController
@RequestMapping("/class")     //sample endpoint--- localhost:8080/rest/class
public class ClassController
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
		
		@GetMapping("/class/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
		public ResponseEntity<com.sag.routes.model.Class> getClassById(@PathVariable("id") Integer id) {
			com.sag.routes.model.Class classes = serviceI.getClassById(id);
			return new ResponseEntity<com.sag.routes.model.Class>(classes, HttpStatus.OK);
		}
		@CrossOrigin
		@GetMapping("/classes")
		public ResponseEntity<List<com.sag.routes.model.Class>> getAllClasses() {
			List<com.sag.routes.model.Class> list = serviceI.getAllClasses();
			return new ResponseEntity<List<com.sag.routes.model.Class>>(list, HttpStatus.OK);
		}

		@PostMapping("/class")
		public ResponseEntity<Void> addClass(@RequestBody com.sag.routes.model.Class class1, UriComponentsBuilder builder) {
			boolean flag = serviceI.addClass(class1);
			if (flag == false) {
				return new ResponseEntity<Void>(HttpStatus.CONFLICT);
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/class/{id}").buildAndExpand(class1.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		@PutMapping("/class")
		public ResponseEntity<com.sag.routes.model.Class> updateClass(@RequestBody com.sag.routes.model.Class class1) {
			serviceI.updateClass(class1);
			return new ResponseEntity<com.sag.routes.model.Class>(class1, HttpStatus.OK);
		}

		@DeleteMapping("/class/{id}")
		public ResponseEntity<Void> deleteClass(@PathVariable("id") Integer id) {
			serviceI.deleteClass(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		
		//getAllClassesByCompusId
		
		
		@GetMapping("/classes/{campus_id}")
		public ResponseEntity<List<com.sag.routes.model.Class>> getAllClassesByCompusId( @PathVariable("campus_id") Integer campus_id) {
			List<com.sag.routes.model.Class> list = serviceI.getAllClassesByCompusId(campus_id);
			return new ResponseEntity<List<com.sag.routes.model.Class>>(list, HttpStatus.OK);
		}
		 
		
		
	}

