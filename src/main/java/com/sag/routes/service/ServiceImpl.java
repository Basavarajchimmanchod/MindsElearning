package com.sag.routes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sag.routes.controller.MedicalDetailsController;
import com.sag.routes.dao.Dao;
import com.sag.routes.model.AttendanceUser;
import com.sag.routes.model.Books;
import com.sag.routes.model.BusDetails;
import com.sag.routes.model.CampusUser;
import com.sag.routes.model.Class;
import com.sag.routes.model.ClassTimeTable;
import com.sag.routes.model.Course;
import com.sag.routes.model.CourseAssessment;
import com.sag.routes.model.CourseGrades;
import com.sag.routes.model.Coursetable;
import com.sag.routes.model.DriverUser;
import com.sag.routes.model.Event;
import com.sag.routes.model.ExamClassMapping;
import com.sag.routes.model.ExamDetails;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.HolidayList;
import com.sag.routes.model.LibrarianUser;
import com.sag.routes.model.Login;
import com.sag.routes.model.Organization;
import com.sag.routes.model.Route;
import com.sag.routes.model.RouteDTO;
import com.sag.routes.model.School;
import com.sag.routes.model.SchoolNews;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.TrainDetailDTO;
import com.sag.routes.model.TrainDetails;
import com.sag.routes.model.UserContext;
import com.sag.routes.model.VehicleDetail;
import blackboard.data.course.CourseMembership;

//Service Implementation for route and bus service with the Annotation @Service
@Service
public class ServiceImpl implements ServiceI {

	// Route Service Implementation

	@Autowired
	private Dao dao;

	@Override
	public Route getRouteById(int routeId) {
		Route obj = dao.getRouteById(routeId);
		return obj;
	}

	@Override
	public List<Route> getAllRoutes() {
		return dao.getAllRoutes();
	}

	@Override
	public synchronized boolean addRoute(Route route) {
		if (dao.routeExists(route.getSource(), route.getDestination())) {
			return false;
		} else {
			dao.addRoute(route);
			return true;
		}
	}

	@Override
	public void updateRoute(Route route) {
		dao.updateRoute(route);
	}

	@Override
	public void deleteRoute(int routeId) {
		dao.deleteRoute(routeId);
	}

	@Override
	public List<RouteDTO> getBusRoute(String source, String destination) {
		List<Object> busRoute = dao.getBusRoute(source, destination);
		List<RouteDTO> routelist = new ArrayList<>();
		for (Object obj : busRoute) {
			Object[] objArray = (Object[]) obj;
			RouteDTO routedto = new RouteDTO();
			routedto.setSource(String.valueOf(objArray[0]));
			routedto.setDestination(String.valueOf(objArray[1]));
			routedto.setRoute_Num(String.valueOf(objArray[2]));
			routelist.add(routedto);
		}
		return routelist;

	}

	// Bus Service Implementation

	@Override
	public BusDetails getBusDetailsById(int busDetailsId) {
		BusDetails obj = dao.getBusDetailsById(busDetailsId);
		return obj;
	}

	@Override
	public List<BusDetails> getAllBusDetails() {
		return dao.getAllBusDetails();
	}

	@Override
	public synchronized boolean addBusDetails(BusDetails busDetails) {
		if (dao.busDetailsExists(busDetails.getRoute_Num())) {
			return false;
		} else {
			dao.addBusDetails(busDetails);
			return true;
		}
	}

	@Override
	public void updateBusDetails(BusDetails busDetails) {
		dao.updateBusDetails(busDetails);
	}

	@Override
	public void deleteBusDetails(int busDetailsId) {
		dao.deleteBusDetails(busDetailsId);
	}

	// Train Service Implementation

	@Override
	public TrainDetails getTrainDetailsById(int trainId) {
		
		TrainDetails obj = dao.getTrainDetailsById(trainId);
		return obj;
	}

	@Override
	public List<TrainDetailDTO> getAllTrainDetails() {
		List<Object> trainRoute = dao.getAllTrainDetails();
		List<TrainDetailDTO> trainlist = new ArrayList<>();
		for (Object obj : trainRoute) {
			Object[] objArray = (Object[]) obj;
			TrainDetailDTO traindto = new TrainDetailDTO();
			traindto.setSource(String.valueOf(objArray[0]));
			traindto.setDestination(String.valueOf(objArray[1]));
			traindto.setRoute(String.valueOf(objArray[2]));
			String hms = getTimeInString(Long.valueOf(String.valueOf(objArray[3])));
			traindto.setTime(hms);
			traindto.setType(String.valueOf(objArray[4]));
			trainlist.add(traindto);
		}

		return trainlist;

		
	}

	@Override
	public synchronized boolean addTrainDetails(TrainDetails trainDetails) {
		if (dao.trainDetailsExists(trainDetails.getSource(), trainDetails.getDestination(), trainDetails.getRoute(),
				trainDetails.getTime(), trainDetails.getType())) {
			return false;
		} else {
			dao.addTrainDetails(trainDetails);
			return true;
		}
	}

	@Override
	public void updateTrainDetails(TrainDetails trainDetails) {
		dao.updateTrainDetails(trainDetails);
	}

	@Override
	public void deleteTrainDetails(int trainId) {
		dao.deleteTrainDetails(trainId);
	}

	@Override
	public List<TrainDetailDTO> getTrainRoute(String source, String destination) {
		List<Object> trainRoute = dao.getTrainRoute(source, destination);
		List<TrainDetailDTO> trainlist = new ArrayList<>();
		for (Object obj : trainRoute) {
			Object[] objArray = (Object[]) obj;
			TrainDetailDTO traindto = new TrainDetailDTO();
			traindto.setSource(String.valueOf(objArray[0]));
			traindto.setDestination(String.valueOf(objArray[1]));
			traindto.setRoute(String.valueOf(objArray[2]));
			String hms = getTimeInString(Long.valueOf(String.valueOf(objArray[3])));
			traindto.setTime(hms);
			traindto.setType(String.valueOf(objArray[4]));
			trainlist.add(traindto);
		}

		return trainlist;

	}
	//To convert given long time which is given in millisecond to hour
	public String getTimeInString(long obj) {
		String hms =String.format("%02d:%02d",TimeUnit.MILLISECONDS.toHours(obj),
				TimeUnit.MILLISECONDS.toSeconds(obj) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(obj)));
		return hms;
	}

	//Student Service  Implementation
	
	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student student = dao.getStudentById(id);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return dao.getAllStudents();
	}

	@Override
	@Transactional
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		if (dao.studentExists(student.getSdId(), student.getUser_id())) {
			return false;
		} else {
			dao.addStudent(student);
			return true;
		}
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		dao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteStudent(id);
	}
	
	
	//Staff Service  Implementation

	@Override
	public Staff getstaffById(Integer id) {
		// TODO Auto-generated method stub
		Staff staff = dao.getstaffById(id);
		return staff;
	}

	@Override
	public List<Staff> getAllstaffs() {
		// TODO Auto-generated method stub
		return dao.getAllstaffs();
	}

	@Override
	public boolean addstaff(Staff staff) {
		// TODO Auto-generated method stub
		if (dao.staffExists(staff.getId(), staff.getUser_id())) {
			return false;
		} else {
			dao.addStaff(staff);
			return true;
		}
	}

	@Override
	public void updatestaff(Staff staff) {
		// TODO Auto-generated method stub
		dao.updatestaff(staff);
	}
	

	@Override
	public void deletestaff(Integer id) {
		// TODO Auto-generated method stub
		dao.deletestaff(id);
	}

	//Guardian Service  Implementation
	@Override
	public GuardianUser getGuardianById(Integer id) {
		// TODO Auto-generated method stub
		GuardianUser guardian = dao.getGuardianById(id);
		return guardian;
	}

	@Override
	public List<GuardianUser> getAllGuardians() {
		// TODO Auto-generated method stub
		return dao.getAllGuardians();
	}

	@Override
	public boolean addGuardian(GuardianUser guardian) {
		// TODO Auto-generated method stub
		if (dao.guardianExists(guardian.getgId(), guardian.getUser_id())) {
			return false;
		} else {
			dao.addGuardian(guardian);
			return true;
		}
	}

	@Override
	public void updateGuardian(GuardianUser guardian) {
		// TODO Auto-generated method stub
		dao.updateGuardian(guardian);
	}

	@Override
	public void deleteGuardian(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteGuardian(id);
	}

	///Librarian  Service  Implementation
	
	@Override
	public LibrarianUser getLibrarianById(Integer id) {
		// TODO Auto-generated method stub
		LibrarianUser librarian = dao.getLibrarianById(id);
		return librarian;
	}

	@Override
	public List<LibrarianUser> getAllLibrarians() {
		// TODO Auto-generated method stub
		return dao.getAllLibrarians();
	}

	@Override
	public boolean addLibrarian(LibrarianUser librarian) {
		// TODO Auto-generated method stub
		if (dao.librarianExists(librarian.getLibId(), librarian.getUser_Id())) {
			return false;
		} else {
			dao.addLibrarian(librarian);
			return true;
		}
	}

	@Override
	public void updateLibrarian(LibrarianUser librarian) {
		// TODO Auto-generated method stub
		dao.updateLibrarian(librarian);
	}

	@Override
	public void deleteLibrarian(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteLibrarian(id);
	}

	
	//Organization Service  Implementation
	@Override
	public Organization getOrganizationById(Integer id) {
		// TODO Auto-generated method stub
		Organization organization = dao.getOrganizationById(id);
		return organization;
	}
	

	@Override
	public List<Organization> getAllOrganization() {
		// TODO Auto-generated method stub
		return dao.getAllOrganization();
	}

	@Override
	public boolean addOrganization(Organization organization) {
		// TODO Auto-generated method stub
		if (dao.organizationExists(organization.getoId(), organization.getoId())) {
			return false;
		} else {
			dao.addOrganization(organization);
			return true;
		}
	}

	@Override
	public void updateOrganization(Organization organization) {
		// TODO Auto-generated method stub
		dao.updateOrganization(organization);
	}

	@Override
	public void deleteOrganization(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteOrganization(id);
	}
	
	//School Service  Implementation

	@Override
	public School getSchoolById(Integer id) {
		// TODO Auto-generated method stub
		School school = dao.getSchoolById(id);
		return school;
	}

	@Override
	public List<School> getAllSchool() {
		// TODO Auto-generated method stub
		return dao.getAllSchool();
	}

	@Override
	public boolean addSchool(School school) {
		// TODO Auto-generated method stub
		if (dao.schoolExists(school.getId(), school.getId())) {
			return false;
		} else {
			dao.addSchool(school);
			return true;
		}
	}

	@Override
	public void updateSchool(School school) {
		// TODO Auto-generated method stub
		dao.updateSchool(school);
	}

	@Override
	public void deleteSchool(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteSchool(id);
	}
	
	
	
	//Campus Service  Implementation
	@Override
	public CampusUser getCampusById(Integer id) {
		// TODO Auto-generated method stub
		CampusUser campus = dao.getCampusById(id);
		return campus;
	}

	@Override
	public List<CampusUser> getAllCampuses() {
		// TODO Auto-generated method stub
		return dao.getAllCampuses();
	}

	@Override
	public boolean addCampus(CampusUser campus) {
		// TODO Auto-generated method stub
		if (dao.CampusExists(campus.getCmId(), campus.getCmId())) {
			return false;
		} else {
			dao.addCampus(campus);
			return true;
		}
	}

	@Override
	public void updateCampus(CampusUser campus) {
		// TODO Auto-generated method stub
		dao.updateCampus(campus);
	}

	@Override
	public void deleteCampus(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteCampus(id);
	}

	//Class Service  Implementation
	
	@Override
	public Class getClassById(Integer id) {
		// TODO Auto-generated method stub
		Class class1=dao.getClassById(id);
		return class1;
	}

	@Override
	public List<Class> getAllClasses() {
		// TODO Auto-generated method stub
		return dao.getAllClasses();
	}

	@Override
	public boolean addClass(Class class1) {
		// TODO Auto-generated method stub
		if (dao.ClassExists(class1.getId(), class1.getId())) {
			return false;
		} else {
			dao.addClass(class1);
			return true;
		}
	}

	@Override
	public void updateClass(Class class1) {
		// TODO Auto-generated method stub
		dao.updateClass(class1);
	}

	@Override
	public void deleteClass(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteClass(id);
	}

	//Course Service  Implementation
	
	@Override
	public Course getCourseById(Integer id) {
		// TODO Auto-generated method stub
		Course course = dao.getCourseById(id);
		return course;
	}

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return dao.getAllCourses();
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		if (dao.CourseExists(course.getId(), course.getId())) {
			return false;
		} else {
			dao.addCourse(course);
			return true;
		}
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		dao.updateCourse(course);
	}

	@Override
	public void deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteCourse(id);
	}

	//Attendance Service  Implementation
	@Override
	public void createattendanceList(int stuid, int classid) {
		// TODO Auto-generated method stub
		
		AttendanceUser attendance=dao.CreateAttendance(stuid,classid);
		
	}

	@Override
	public void createUserContext(int id, int id2) {
		// TODO Auto-generated method stub
		UserContext usercontext=dao.createUserContext(id,id2);
	}

	@Override
	public void getattendanceList(int stud_id, int class_id) {
		// TODO Auto-generated method stub
		AttendanceUser attendance=dao.getAttendance(stud_id,class_id);
	}

	@Override
	public List<AttendanceUser> getattendanceList(int stud_id) {
		// TODO Auto-generated method stub
		List<AttendanceUser> attendance=dao.getAttendanceList(stud_id);
		return attendance;
	}

	//getStudentUserListByCampusId
	
	@Override
	public List<Student> getStudentUserListByCampusId(Integer stud_id) {
		// TODO Auto-generated method stub
		
		return dao.getStudentListByCampusId(stud_id);
	
	}
	
	//getStudentListByClassId

	@Override
	public List<Student> getStudentListByClassId(Integer classId) {
		// TODO Auto-generated method stub
		List<Student> student=dao.getStudentListByClassId(classId);
		return student;
	}
	
  //getStudentVehicleDetailsByStudentAdmNum
	@Override
	public Student getStudentVehicleDetailsByStudentAdmNum(
			Integer stdadmissionno) {
		// TODO Auto-generated method stub
		Student student=dao.getStudentVehicleDetailsByStudentAdmNum(stdadmissionno);
		return student;
	}

	//getStdUserByStdAdmissionNumber
	
	@Override
	public Student getStdUserByStdAdmissionNumber(Integer Studentadminno) {
		// TODO Auto-generated method stub
		Student student=dao.getStdUserByStdAdmissionNumber(Studentadminno);
		return student;
	}

	//getStudentEventDetailsByStudentUserId
	
	@Override
	public List<Event >getStudentEventDetailsByStudentUserId(int studentUserId) {
		// TODO Auto-generated method stub
		List<Event> event=dao.getStudentEventDetailsByStudentUserId(studentUserId);
		return event;
	}

	//getStudentVehicleDetailsByStudentVehicleId
	
	@Override
	public VehicleDetail getStudentVehicleDetailsByStudentVehicleId(
			int vehicleId) {
		// TODO Auto-generated method stub
		VehicleDetail vehicledetails=dao.getStudentVehicleDetailsByStudentVehicleId(vehicleId);
		return vehicledetails;
	}
//getStudentDetailByStdAdmNum
	
	@Override
	public List<Student> getStudentDetailByStdAdmNum(Integer Studentadminno) {
		// TODO Auto-generated method stub
		List<Student> student=dao.getStudentDetailByStdAdmNum(Studentadminno);
		return student;
	}

	//getStaffUserListByClassId
	
	@Override
	public List<Staff> getStaffUserListByClassId(Integer classId) {
		// TODO Auto-generated method stub
		List<Staff> staff=dao.getStaffUserListByClassId(classId);
		return staff;
	}
	
	//getStaffUserListByCampusId
	
		
		@Override
		public List<Staff> getStaffUserListByCampusId(Integer campusId) 
		{
			// TODO Auto-generated method stub
						List<Staff> staff=dao.getStaffUserListByCampusId(campusId);
						return staff;
		}

		@Override
		public List<Class> getAllClassesByCompusId(Integer campus_id) {
			List<Class> class1 =dao.getAllClassesByCompusId(campus_id);
			return class1;
		}

	@Override
	public List<Books> getBookListByCampusId(Integer campusId) {
		List<Books> book =dao.getBookListByCampusId(campusId);
		return book;
	}

	@Override
	public List<Student> getListOfStudentByCampusIdWhoHasTakenBooks(
			Integer campus_id,Integer BookId) {
		// TODO Auto-generated method stub
		List<Student> book =dao.getListOfStudentByCampusIdWhoHasTakenBooks(campus_id,BookId);
		return book;
	}

	@Override
	public List<Student> getStudentWhoHasReturnBook(Integer campus_id) {
		List<Student> book =dao.getStudentWhoHasReturnBook(campus_id);
		return book;
		
	}

	@Override
	public DriverUser getdriverdetailsByID(Integer dId) {
		// TODO Auto-generated method stub
		
		DriverUser driver=dao.getdriverdetailsByID(dId);
		return driver;
	}

	@Override
	public List<DriverUser> getdriverdetailsByCampusID(Integer campusId) {
		List<DriverUser> driver=dao.getdriverdetailsByCampusID(campusId);
		return driver;
	}

	@Override
	public List<VehicleDetail> getVehicleListByCampusId(Integer campusId) {
		// TODO Auto-generated method stub
		List<VehicleDetail> vehicle=dao.getVehicleListByCampusId(campusId);
		return vehicle;
	}

	@Override
	public List<VehicleDetail> getVehicleListByCampusIdDriverId(Integer campusId, Integer driverId) {
		// TODO Auto-generated method stub
		List<VehicleDetail> vehicle=dao.getVehicleListByCampusIdDriverId(campusId,driverId);
		return vehicle;
	}

	@Override
	public ExamDetails getExamById(Integer EttId) {
		// TODO Auto-generated method stub
		ExamDetails exam=dao.getExamById(EttId);
		return exam;
	}

	@Override
	public List<ExamDetails> getExamDetails() {
		// TODO Auto-generated method stub
	List<ExamDetails> exams=dao.getExamDetails();
	return exams;
	}

	@Override
	public List<ExamClassMapping> getExamTimeTableByClassId(Integer classId) {
		List<ExamClassMapping> examDetails=dao.getExamTimeTableByClassId(classId);
		return examDetails;
		
	}

	@Override
	public List<ClassTimeTable> getClassTimeTableByClassId(Integer classId) {
		// TODO Auto-generated method stub
		List<ClassTimeTable> classDetails=dao.getClassTimeTableByClassId(classId);
		return classDetails;
	}

	@Override
	public void getSchoolNewsListBySchoolId(Integer id) {
		// TODO Auto-generated method stub
		SchoolNews schooln=dao.getSchoolNewsListBySchoolId(id);
		
	}

	@Override
	public void getSchoolListByCampusId(Integer id) {
		// TODO Auto-generated method stub
		School schoollist=dao.getSchoolListByCampusId(id);
	}

	@Override
	public com.sag.routes.model.MedicalDetails getMedicalDetailsById(Integer mid) {
		// TODO Auto-generated method stub
		com.sag.routes.model.MedicalDetails medicaldetails=dao.getMedicalDetailsById(mid);
		return medicaldetails;
		
	}

	@Override
	public List<com.sag.routes.model.MedicalDetails> getMedicalDetails() {
		// TODO Auto-generated method stub
	List<com.sag.routes.model.MedicalDetails> medicaldetails=dao.getMedicalDetails();
	return medicaldetails;
	
	}

	@Override
	public boolean addMedicalDetails(com.sag.routes.model.MedicalDetails medical) {
		// TODO Auto-generated method stub
		if (dao.MedicalExists(medical.getMid(), medical.getMid())) {
			return false;
		} else {
			dao.addMedical(medical);
			return true;
		}
	}

	@Override
	public void updateMedical(com.sag.routes.model.MedicalDetails medical) {
		// TODO Auto-generated method stub
		dao.updateMedical(medical);
	}

	@Override
	public void deleteMedical(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteMedicalDetails(id);
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		dao.addStudentDetails(student);
		return student;
	}

	@Override
	public List<HolidayList> getHolidayListByCampusId(Integer campusId) {
		// TODO Auto-generated method stub
		List<HolidayList> holidays=dao.getHolidayListByCampusId(campusId);
		return holidays;
	}

	@Override
	public HolidayList getHolidayListById(Integer hId) {
		// TODO Auto-generated method stub
		HolidayList holidays=dao.getHolidayListById(hId);
		return holidays;
	}

	@Override
	public Login getLoginById(Integer id) {
		// TODO Auto-generated method stub
		Login login= dao.getLoginDetailsById(id);
				return login;
	}

	@Override
	public List<Login> getAllLogins() {
		// TODO Auto-generated method stub
		List<com.sag.routes.model.Login> logindetails=dao.getLoginDetails();
		return logindetails;
	}

	/*@Override
	public List<Coursetable> getCourseDetailsById(Integer courseId) {
		// TODO Auto-generated method stub
		List<Coursetable> course = dao.getCourseDetailsById(courseId);
		return course;
	}*/

	@Override
	public List<CourseAssessment> getCourseAssessmentDetails(Integer courseId,Integer AssessmentId) {
		// TODO Auto-generated method stub
		List<CourseAssessment> courseAssesment = dao.getCourseAssessmentDetails(courseId,AssessmentId);
		return courseAssesment;
	}

	@Override
	public List<Coursetable> getAllCoursesList() {
		// TODO Auto-generated method stub
		List<com.sag.routes.model.Coursetable> coursedetails=dao.getAllCoursesList();
		return coursedetails;
	}

	@Override
	public List<Coursetable> getCourseDetailsById(Integer courseId) {
		// TODO Auto-generated method stub
		List<com.sag.routes.model.Coursetable> coursedetails=dao.getCourseDetailsById(courseId);
		return coursedetails;
	}

	@Override
	public List<CourseGrades> getCourseGradeDetails(Integer courseId) {
		// TODO Auto-generated method stub
		List< CourseGrades> courseAssesment = dao.getCourseGradeDetails(courseId);
		return courseAssesment;
	}

	@Override
	public List<CourseMembership> getCourseMembersDetails(Integer user_id) {
		// TODO Auto-generated method stub
		List<CourseMembership> courseMembers = dao.getCourseMembersDetails(user_id);
		return courseMembers;
	}

	@Override
	public boolean addCourse(Coursetable coursetab) {
		// TODO Auto-generated method stub
		if (dao.CoursedataExists(coursetab.getCourseId(), coursetab.getOrganization())) {
			return false;
		} 
		else {
			dao.addCourseDetail(coursetab);
			return true;
		}
	}

	@Override
	public List<Coursetable> getCourseTermDetailsById(Integer termId) {
		// TODO Auto-generated method stub
		List<Coursetable> courseTerm = dao.getCourseTermDetailsById(termId);
		return courseTerm;
	}
	
	

	/*@Override
	public Coursetable getCourseAssessmentDetails(Integer courseId) {
		// TODO Auto-generated method stub
		List<Coursetable> course = dao.getCourseDetailsById(courseId);
		return course;
	}
	*/
}

	
		

