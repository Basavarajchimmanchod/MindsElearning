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

import com.sag.routes.model.TrainDetailDTO;
import com.sag.routes.model.TrainDetails;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints
@RestController
@RequestMapping("/train")  
public class TrainController {
	
	// Train Controller
	
		/*
		 * @GetMapping--specifies GET method
		 * @PostMapping--specifies POST method
		 * @PutMapping--specifies PUT method
		 * @DeleteMapping--specifies DELETE method
		 */
	
	final static Logger logger = Logger.getLogger(RouteController.class);

	@Autowired
	private ServiceI serviceI;
	@CrossOrigin
	@GetMapping("/routes")   //sample endpoint ------ localhost:8080/rest/train/routes
	public ResponseEntity<List<TrainDetailDTO>> getAllTrainDetails() {
		List<TrainDetailDTO> list = serviceI.getAllTrainDetails();
		return new ResponseEntity<List<TrainDetailDTO>>(list, HttpStatus.OK);
	}

	@PostMapping("/createtrain") //sample endpoint ----- localhost:8080/rest/train/createtrain
	public ResponseEntity<Void> addTrainDetails(@RequestBody TrainDetails train, UriComponentsBuilder builder) {
		boolean flag = serviceI.addTrainDetails(train);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/train/{id}").buildAndExpand(train.getTrainId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/updatetrain")  //sample endpoint ------- localhost:8080/rest/train/updatetrain
	public ResponseEntity<TrainDetails> updateTrainDetails(@RequestBody TrainDetails train) {
		serviceI.updateTrainDetails(train);
		return new ResponseEntity<TrainDetails>(train, HttpStatus.OK);
	}

	@DeleteMapping("/deletetrain/{id}")  //sample endpoint ----- localhost:8080/rest/train/deletetrain
	public ResponseEntity<Void> deleteTrainDetails(@PathVariable("id") Integer id) {
		serviceI.deleteTrainDetails(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@CrossOrigin
	@GetMapping("/time") // eg:train/time?source=velachery&destination=madipakkam
	public List<TrainDetailDTO> getTrainRoute(@RequestParam(value = "source", required = true) String source,
			@RequestParam(value = "destination", required = false) String destination) {
		List<TrainDetailDTO> train = serviceI.getTrainRoute(source, destination);
		logger.info(source + destination);
		return train;

	}

}
