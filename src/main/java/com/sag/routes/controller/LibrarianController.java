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

import com.sag.routes.model.Books;




import com.sag.routes.model.Books;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.LibrarianUser;
/*import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;*/
import com.sag.routes.model.Student;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/librarian")     //sample endpoint--- localhost:8080/rest/bus
public class LibrarianController {

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
	
	@GetMapping("/librarian/{id}")   //sample endpoint---- localhost:8080/rest/bus/route/{id}
	public ResponseEntity<LibrarianUser> getLibrarianById(@PathVariable("id") Integer id) {
		LibrarianUser librarian = serviceI.getLibrarianById(id);
		return new ResponseEntity<LibrarianUser>(librarian , HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/librarians")
	public ResponseEntity<List<LibrarianUser>> getAllLibrarians() {
		List<LibrarianUser> list = serviceI.getAllLibrarians();
		return new ResponseEntity<List<LibrarianUser>>(list, HttpStatus.OK);
	}

	@PostMapping("/librarian")
	public ResponseEntity<Void> addLibrarian(@RequestBody LibrarianUser librarian, UriComponentsBuilder builder) {
		boolean flag = serviceI.addLibrarian(librarian);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/librarian/{id}").buildAndExpand(librarian.getLibId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("/librarian")
	public ResponseEntity<LibrarianUser> updateLibrarian(@RequestBody LibrarianUser librarian) {
		serviceI.updateLibrarian(librarian);
		return new ResponseEntity<LibrarianUser>(librarian, HttpStatus.OK);
	}

	@DeleteMapping("/librarian/{id}")
	public ResponseEntity<Void> deleteLibrarian(@PathVariable("id") Integer id) {
		serviceI.deleteLibrarian(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	//getBookListByCampusId
	@GetMapping("/libraryBookList/{campusId}") 
	public ResponseEntity<List<Books>> getBookListByCampusId(@PathVariable("campusId") Integer campusId) {
	List<Books> books=	serviceI.getBookListByCampusId(campusId);
		return new ResponseEntity<List<Books>>(books, HttpStatus.OK);
	}
	
	//getListOfStudentByCampusIdWhoHasTakenBooks
	
	@GetMapping("/libraryBookListByCampusId/{campusId}/{bookId}") 
	public ResponseEntity<List<Student>> getListOfStudentByCampusIdWhoHasTakenBooks(@PathVariable("campusId") Integer campusId,@PathVariable("bookId") Integer bookId) {
	List<Student> students	=serviceI.getListOfStudentByCampusIdWhoHasTakenBooks(campusId,bookId);
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
 }
	
 //getStudentWhoHasReturnBook
	@GetMapping("/getStudentWhoHasReturnBook/{campusId}") 
	public ResponseEntity<Student> getStudentWhoHasReturnBook(@PathVariable("campusId") Integer campusId) {
		serviceI.getStudentWhoHasReturnBook(campusId);
		return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
 }
	
	
	
	
	
	}
