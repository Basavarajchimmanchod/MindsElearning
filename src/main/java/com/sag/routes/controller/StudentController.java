package com.sag.routes.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;







import com.sag.routes.model.AttendanceUser;
import com.sag.routes.model.Event;
/*import com.sag.routes.model.BusDetails;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;*/
import com.sag.routes.model.Student;
import com.sag.routes.model.StudentClassMapping;
import com.sag.routes.model.User;
import com.sag.routes.model.UserLogin;
import com.sag.routes.model.VehicleDetail;
import com.sag.routes.service.ServiceI;

//RestController which contains all REST endpoints

@RestController
@RequestMapping("/student")     //sample endpoint--- localhost:8080/rest/student
public class StudentController {

	final static Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private ServiceI serviceI;
	

	// Student Controller
	
	/*
	 * @GetMapping--specifies GET method
	 * @PostMapping--specifies POST method
	 * @PutMapping--specifies PUT method
	 * @DeleteMapping--specifies DELETE method
	 */
	
	@GetMapping("/student/{id}")   //sample endpoint---- localhost:8080/rest//student/{id}
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		Student student = serviceI.getStudentById(id);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		System.out.println("Get Students inside");
		List<Student> list = serviceI.getAllStudents();
		return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
	}

	/*@PostMapping("/student")
	public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder builder) {
		boolean flag = serviceI.addStudent(student);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/student/{id}").buildAndExpand(student.getSdId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}*/
	
	
	@RequestMapping(value = "/api/student", method = {RequestMethod.GET,RequestMethod.POST})
public ResponseEntity<Student> createStudent(@RequestBody Student student){

    Student studentSaved =serviceI.save(student);
    return new ResponseEntity <Student> (studentSaved, HttpStatus.CREATED);
    }

	
	
	@PutMapping("/student")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		serviceI.updateStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}

	@DeleteMapping("/student/{studentid}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("studentid") Integer id) {
		serviceI.deleteStudent(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	//createAttendance
	  
	@GetMapping("/studentAttendances/{classid}")
	  public void getAttendances(@RequestBody  AttendanceUser attendance , @RequestBody StudentClassMapping studentClassMap) 
	  {
		 /*StudentClassMapping studentClassMap=new StudentClassMapping();
	         int stdid =studentClassMap.getClass_id();*/
	      //serviceI.getAttendancesList(attendance.getStud_id(),studentClassMap.getClass_id());
	      
	    }  
	
	  @GetMapping("StudentAttendance/{stuid_id}")
	  public ResponseEntity<List<AttendanceUser>>  getAttendance(@PathVariable("stuid_id") Integer stuid_id) 
	  {
		 
		  List<AttendanceUser> attendance = serviceI.getattendanceList(stuid_id);
		  return new ResponseEntity<List<AttendanceUser>>(attendance, HttpStatus.OK);
	     
	      
	    } 
	  
	  
	  
	  @GetMapping("getStudentUserListByCampusId/{cmId}")
	  public ResponseEntity<List<Student>> getStudentUserListByCampusId( @PathVariable("cmId") Integer cmId) 
	 {
		  List<Student> student = serviceI.getStudentUserListByCampusId(cmId);
		  return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
	       
	  }
	  
	  
	  @GetMapping("getStudentUserListByClassId/{classId}")
	  public ResponseEntity<List<Student>> getStudentListByClassId(@PathVariable("classId") Integer classId) 
		 {
			  List<Student> student = serviceI.getStudentListByClassId(classId);
			 return new ResponseEntity<List<Student>>(student, HttpStatus.OK);
		       
		  }
	  
	  @GetMapping("getStudentVehicleDetailsByStudentAdmNum/{Studentadminno}")
	  public ResponseEntity<VehicleDetail> getStudentVehicleDetailsByStudentAdmNum(@PathVariable("Studentadminno") Integer Studentadminno) 
	  {
	   Student studentUser = serviceI.getStudentVehicleDetailsByStudentAdmNum(Studentadminno);
	   VehicleDetail vehicleDetails = serviceI.getStudentVehicleDetailsByStudentVehicleId(studentUser.getVehicleId());
	   return new ResponseEntity<VehicleDetail>(vehicleDetails, HttpStatus.OK);
	 }
	 
	  @GetMapping("getStudentEventDetailsByAdmissionNumber/{studentUserId}")
	  public ResponseEntity<List<Event>> getStudentEventDetailsByAdmissionNumber(@PathVariable("studentUserId") Integer studentUserId) 
	  {
	  // Student studentUser = serviceI.getStdUserByStdAdmissionNumber(Studentadminno);
	   List<Event> eventDetails = serviceI.getStudentEventDetailsByStudentUserId(studentUserId);
	   return new ResponseEntity<List<Event>>(eventDetails, HttpStatus.OK);
	 }
	  
	  
	  @GetMapping("getStudentDetailByStdAdmNum/{Studentadminno}")
	  public ResponseEntity<List<Student>> getStudentDetailByStdAdmNum(@PathVariable("Studentadminno") Integer Studentadminno) 
	  {
	  List<Student> studentUser = serviceI.getStudentDetailByStdAdmNum(Studentadminno);
			  return new ResponseEntity<List<Student>>(studentUser, HttpStatus.OK);
	 }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  /*
	  
	  def getStudentUserByFirstname(Firstname : String) = Action.async{ request =>
	    
	    userService.getStudentUserByFirstname(Firstname).map{ StudentUser =>
	      Ok(toJson(StudentUser))
	  }
	  }
	  
	  def getStudentAttendenceListByClassId(classId : Long) = Action.async { request =>
	    val attendanceCommonList = userService.getStudentAttendenceListByClassId(classId)
	    var attendanceUserList = new ListBuffer[AttendanceUser]()
	    
	    for(attendanceTemp <- attendanceCommonList){
	     var attendanceUser = AttendanceUser(
	          id = 0,stud_id = attendanceTemp.user_id,Studentadminno = attendanceTemp.Studentadminno,Firstname = attendanceTemp.Firstname,
	          remark = None,status = 1,DOI = Calendar.getInstance().getTime(),updatedon = Calendar.getInstance().getTime(),
	          className = attendanceTemp.className,campusName = attendanceTemp.campusName,orgName = attendanceTemp.orgName)
	     
	     attendanceUserList += attendanceUser  
	    }
	     Future(Ok(toJson(attendanceUserList)))
	  }
	  
	  
	  def getListOfStudentByCampusIdWhoHasTakenBooks(campusId : Long) = Action.async { request =>
	    val listOfStudentWhoHasTakenBooks = userService.getListOfStudentByCampusIdWhoHasTakenBooks(campusId)
	   Future(Ok(toJson(listOfStudentWhoHasTakenBooks)))
	 }
	  
	  
	  def getStudentWhoHasReturnBook(stdUserId : Long) = Action.async { request =>
	   val bookIssueReturn = userService.getStudentWhoHasReturnBookByStdUserId(stdUserId)
	   val updateStudentWhoHasReturnBook = userService.updateStudentWhoHasReturnBook(bookIssueReturn)
	   Future(Ok(toJson(bookIssueReturn)))
	 }
	  
	  
	  def getStudentDetailByStdAdmNum(admNum : String) = Action.async { request =>
	  val studentUser = userService.getStdUserByStdAdmissionNumber(admNum)
	  Future(Ok(toJson(studentUser)))
	 }
	  
	  def getStudentMedicalDetailsByStudentAdmNum(stdadmissionno : String) = Action.async { request =>
	   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
	   val medicalDetails = userService.getStudentMedicalDetailsByStudentUserId(studentUser.user_id)
	   Future(Ok(toJson(medicalDetails)))
	 }
	 
	 def getStudentVehicleDetailsByStudentAdmNum(stdadmissionno : String) = Action.async { request =>
	   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
	   val vehicleDetails = userService.getStudentVehicleDetailsById(studentUser.vehicleId)
	   Future(Ok(toJson(vehicleDetails)))
	 }
	 
	 
	 def getStudentEventDetailsByAdmissionNumber(stdadmissionno : String) = Action.async { request =>
	   val studentUser = userService.getStdUserByStdAdmissionNumber(stdadmissionno)
	   val eventDetails = userService.getStudentEventDetailsByStudentUserId(studentUser.user_id)
	   Future(Ok(toJson(eventDetails)))
	 }
	 
	 
	 def getStudentPeriviousDetailByStdAdmNum(stdAdmNum : String) = Action.async { request =>
	   val stdClassTermList = userService.getStudentPeriviousDetailByStdAdmNum(stdAdmNum)
	   val studentClassTermList = new ListBuffer[StdClassTerm]()
	   for(stdClassTerm <- stdClassTermList)
	   {
	     var sClassTerm = stdClassTerm
	     sClassTerm.termStartDate = stdClassTerm.termStartDate.toString()
	     sClassTerm.termEndDate = stdClassTerm.termEndDate.toString()
	     studentClassTermList += sClassTerm
	   }
	   Future(Ok(toJson(studentClassTermList)))
	 }
	  
	  
	  
	  
	
	
	  public void createUserContext(User user,UserLogin userlogin)
	  {
		  serviceI.createUserContext(user.getId(),userlogin.getId());
	  }
	*/
	
	
	
	
	}
