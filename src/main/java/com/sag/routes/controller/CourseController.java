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

import com.sag.routes.model.Course;
import com.sag.routes.service.ServiceI;

@RestController
@RequestMapping("/course")     //sample endpoint--- localhost:8080/rest/course
public class CourseController 
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
			
			@GetMapping("/course/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
			public ResponseEntity<com.sag.routes.model.Course> getCourseById(@PathVariable("id") Integer id) {
				com.sag.routes.model.Course course = serviceI.getCourseById(id);
				return new ResponseEntity<com.sag.routes.model.Course>(course, HttpStatus.OK);
			}
			@CrossOrigin
			@GetMapping("/courses")
			public ResponseEntity<List<Course>> getAllCourses() {
				List<Course> list = serviceI.getAllCourses();
				return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
			}

			@PostMapping("/course")
			public ResponseEntity<Void> addCourse(@RequestBody Course course, UriComponentsBuilder builder) {
				boolean flag = serviceI.addCourse(course);
				if (flag == false) {
					return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				}
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(builder.path("/course/{id}").buildAndExpand(course.getId()).toUri());
				return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}

			@PutMapping("/course")
			public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
				serviceI.updateCourse(course);
				return new ResponseEntity<Course>(course, HttpStatus.OK);
			}

			@DeleteMapping("/course/{id}")
			public ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) {
				serviceI.deleteCourse(id);
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			
		}
