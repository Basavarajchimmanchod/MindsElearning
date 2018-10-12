package com.sag.routes.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sag.routes.model.Login;
import com.sag.routes.service.ServiceI;


	@RestController
	@RequestMapping("/credentials")     //sample endpoint--- localhost:8080/rest/LoginCredentials
	public class LoginController {

		final static Logger logger = Logger.getLogger(LoginController.class);

		@Autowired
		private ServiceI serviceI;
		

		// Student Controller
		
		/*
		 * @GetMapping--specifies GET method
		 * @PostMapping--specifies POST method
		 * @PutMapping--specifies PUT method
		 * @DeleteMapping--specifies DELETE method
		 */
		
		@GetMapping("/login/{id}")   //sample endpoint---- localhost:8080/rest//student/{id}
		public ResponseEntity<Login> getLoginById(@PathVariable("id") Integer id) {
			Login login = serviceI.getLoginById(id);
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		}
		@CrossOrigin
		@GetMapping("/logins")
		public ResponseEntity<List<Login>> getAllLogins() {
			System.out.println("Get Login inside");
			List<Login> list = serviceI.getAllLogins();
			return new ResponseEntity<List<Login>>(list, HttpStatus.OK);
		}
}
