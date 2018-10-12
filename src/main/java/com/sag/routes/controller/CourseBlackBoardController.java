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
import com.sag.routes.model.CourseAssessment;
import com.sag.routes.model.CourseGrades;
import com.sag.routes.model.Coursetable;
import com.sag.routes.service.ServiceI;

import blackboard.data.course.CourseMembership;

@RestController
@RequestMapping("coursetable")     //sample endpoint--- localhost:8080/rest/courses
public class CourseBlackBoardController 
{

final Logger logger = Logger.getLogger(CourseBlackBoardController.class);

			@Autowired
			private ServiceI serviceI;
			

			// CourseBlackBoardController Controller
			
			/*
			 * @GetMapping--specifies GET method
			 * @PostMapping--specifies POST method
			 * @PutMapping--specifies PUT method
			 * @DeleteMapping--specifies DELETE method
			 */
			
			
			
			
			//Blackborad Course Details
			
			
			//CourseDetails to be Retrieved Based on its CourseId
			
			@GetMapping("/learn/api/public/els/courses/{courseId}")   //sample endpoint---- localhost:8080/rest/courses/{courseId}
			public ResponseEntity<List<Coursetable>> getCourseDetailsById(@PathVariable("courseId") Integer courseId) {
				List<Coursetable> coursetab = serviceI.getCourseDetailsById(courseId);
				return new ResponseEntity<List<Coursetable>>(coursetab,HttpStatus.OK);
			}
			
			
			
			//CourseAssessment Details to be Retrieved Based on its CourseId and AssessmentId
			
			@GetMapping("/learn/api/public/els/courses/{courseId}/assessment/{assessmentId}")   //sample endpoint---- localhost:8080/rest/courses/{courseId}/{assessmentId}
			public ResponseEntity<List<CourseAssessment>> getCourseAssessmentDetails(@PathVariable("courseId") Integer courseId,@PathVariable("assessmentId") Integer assessmentId) {
				List<CourseAssessment> courseAssess = serviceI.getCourseAssessmentDetails(courseId,assessmentId);
				return new ResponseEntity<List<CourseAssessment>>(courseAssess,HttpStatus.OK);
			}
			
			
			//CourseGrades Details to be Retrieved Based on its CourseId 
			
			@GetMapping("/learn/api/public/els/courses/grade/{courseId}")    //sample endpoint---- localhost:8080/rest/courses/{courseId}
			public ResponseEntity <List<CourseGrades>>  getCourseGradeDetails(@PathVariable("courseId") Integer courseId) {
		   List<CourseGrades> coursegrade = serviceI.getCourseGradeDetails(courseId);
				return new ResponseEntity<List<CourseGrades>>(coursegrade,HttpStatus.OK);
			}
			
			//CourseMembership Details to be Retrieved Based on its sdId 
			
			@GetMapping("/learn/api/public/els/courses/{sdId}")   //sample endpoint---- localhost:8080/rest/courses/{sdId}
			
			public ResponseEntity <List<CourseMembership>>  getCourseMembersDetails(@PathVariable("sdId") Integer sdId)
			{
		       List<CourseMembership> coursemember = serviceI.getCourseMembersDetails(sdId);
				return new ResponseEntity<List<CourseMembership>>(coursemember,HttpStatus.OK);
		       
			}
			
			
			@CrossOrigin
			@GetMapping("/learn/api/public/els/courses/courseDetail")
			public ResponseEntity<List<Coursetable>> getAllCoursesList() {
				List<Coursetable> list = serviceI.getAllCoursesList();
				return new ResponseEntity<List<Coursetable>>(list, HttpStatus.OK);
			}
			
			

			//CourseDetails to be Inserted or to be Addedd
			
			@PostMapping("/learn/api/public/els/courses/addcourses")
			public ResponseEntity<Void> addCourse(@RequestBody Coursetable coursetab, UriComponentsBuilder builder) {
				boolean flag = serviceI.addCourse(coursetab);
				if (flag == false) {
					return new ResponseEntity<Void>(HttpStatus.CONFLICT);
				}
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(builder.path("/learn/api/public/els/courses/addcourses/{courseId}").buildAndExpand(coursetab.getCourseId()).toUri());
				return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
			}

			//Update Courses based on CourseId
			
			@PutMapping("/learn/api/public/els/updatecourses")
			public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
				serviceI.updateCourse(course);
				return new ResponseEntity<Course>(course, HttpStatus.OK);
			}

			//Delete Course Based on CourseId
			
			@DeleteMapping("/learn/api/public/els/deletecourse/{id}")
			public ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) {
				serviceI.deleteCourse(id);
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
			
			
			
			@GetMapping("/learn/api/public/els/courses/term/{termId}")   //sample endpoint---- localhost:8080/rest/courses/{courseId}
			public ResponseEntity<List<Coursetable>> getCourseTermDetailsById(@PathVariable("termId") Integer termId) {
				List<Coursetable> coursetab = serviceI.getCourseTermDetailsById(termId);
				return new ResponseEntity<List<Coursetable>>(coursetab,HttpStatus.OK);
			}
			
				
			
			
				
		}



