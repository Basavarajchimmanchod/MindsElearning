package com.sag.routes.dao;

import java.util.List;

import com.sag.routes.controller.MedicalDetailsController;
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
import com.sag.routes.model.School;
import com.sag.routes.model.SchoolNews;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.TrainDetails;
import com.sag.routes.model.UserContext;
import com.sag.routes.model.VehicleDetail;

import blackboard.data.course.CourseMembership;

//CRUD Operations

public interface Dao {

	// Route DAO

	// Get all available routes
	List<Route> getAllRoutes();

	// Get Bus route number for given source and destination
	public List<Object> getBusRoute(String source, String destination);

	// Get routes based on ID
	Route getRouteById(int routeId);

	void addRoute(Route route);

	void updateRoute(Route route);

	void deleteRoute(int routeId);

	// Check whether route ID exists or not to create a new route to avoid
	// duplication
	//boolean routeExists(String source, String destination);

	// Bus DAO
	// Get all available bus number
	List<BusDetails> getAllBusDetails();

	// Get bus number based on ID
	BusDetails getBusDetailsById(int busDetailsId);

	void addBusDetails(BusDetails busDetails);

	void updateBusDetails(BusDetails busDetails);

	void deleteBusDetails(int busDetailsId);

	// Check whether bus ID exists or not to create a new bus number to avoid
	// duplication
	boolean busDetailsExists(String route_Num);
	
	
	
	// Train DAO

		// Get all available routes
		public List<Object> getAllTrainDetails();

		// Get Train timings for given source and destination
		public List<Object> getTrainRoute(String source, String destination);

		// Get routes based on ID
		TrainDetails getTrainDetailsById(int trainId);

		void addTrainDetails(TrainDetails trainDetails);

		void updateTrainDetails(TrainDetails trainDetails);

		void deleteTrainDetails(int trainDetailsId);
		// Check whether route ID exists or not to create a new route to avoid
		// duplication
		boolean trainDetailsExists(String source, String destination,String route,long time,String type);
		
		// Student DAO

		Student getStudentById(int id);

		List<Student> getAllStudents();

		void addStudent(Student student);

		boolean studentExists(int id, int i);

		void updateStudent(Student student);

		void deleteStudent(Integer id);
		
		// Staff DAO

		Staff getstaffById(Integer id);

		List<Staff> getAllstaffs();

		void addStaff(Staff staff);

		boolean staffExists(int id, int i);

		void updatestaff(Staff staff);

		void deletestaff(Integer id);
		
		
		// Guardian DAO

		GuardianUser getGuardianById(Integer id);

		List<GuardianUser> getAllGuardians();

		//boolean guardianExists(long id, int i);

		void addGuardian(GuardianUser guardian);

		void updateGuardian(GuardianUser guardian);

		void deleteGuardian(Integer id);

		
		// LibrarianUser DAO
		
		LibrarianUser getLibrarianById(Integer id);

		List<LibrarianUser> getAllLibrarians();

		//boolean librarianExists(long id, int i);

		void addLibrarian(LibrarianUser librarian);

		void updateLibrarian(LibrarianUser librarian);

		void deleteLibrarian(Integer id);
		
		
		// Organization DAO

		Organization getOrganizationById(Integer id);

		List<Organization> getAllOrganization();

		boolean organizationExists(int id, int id2);

		void addOrganization(Organization organization);

		void updateOrganization(Organization organization);

		void deleteOrganization(Integer id);

		
		// School DAO
		
		School getSchoolById(Integer id);

		List<School> getAllSchool();

		void addSchool(School school);

		boolean schoolExists(int id, int id2);

		void updateSchool(School school);

		void deleteSchool(Integer id);
		
		
		// CampusUser DAO

		CampusUser getCampusById(Integer id);

		List<CampusUser> getAllCampuses();

		boolean CampusExists(int id, int id2);

		void addCampus(CampusUser campus);

		void updateCampus(CampusUser campus);

		void deleteCampus(Integer id);
		
		// Class DAO
		
		Class getClassById(Integer id);

		List<Class> getAllClasses();

		boolean ClassExists(int id, int id2);

		void addClass(Class class1);

		void updateClass(Class class1);

		void deleteClass(Integer id);
		
		//Course  DAO

		Course getCourseById(Integer id);

		List<Course> getAllCourses();

		void addCourse(Course course);

		boolean CourseExists(int id, int id2);

		void updateCourse(Course course);

		void deleteCourse(Integer id);
		
		
		//AttendanceUser  DAO
		
		AttendanceUser CreateAttendance(int stuid, int classid);

		boolean guardianExists(int id, int userid);

		boolean librarianExists(int id, int userid);

		UserContext createUserContext(int id, int id2);

		AttendanceUser getAttendance(int stud_id, int class_id);

		List<AttendanceUser> getAttendanceList(int stud_id);
		
		//getStudentListByCampusId

		List<Student> getStudentListByCampusId(Integer stud_id);

		//getStudentListByClassId
		
		List<Student> getStudentListByClassId(int classId);
		
         //getStudentVehicleDetailsByStudentAdmNum
		Student getStudentVehicleDetailsByStudentAdmNum(Integer stdadmissionno);

		//getStdUserByStdAdmissionNumber
		
		Student getStdUserByStdAdmissionNumber(Integer stdadmissionno);
		
          //getStudentEventDetailsByStudentUserId
		
		List<Event> getStudentEventDetailsByStudentUserId(int studentUserId);

		//getStudentDetailByStdAdmNum

		List<Student> getStudentDetailByStdAdmNum(Integer Studentadminno);

		//getStudentVehicleDetailsByStudentVehicleId
		
		VehicleDetail getStudentVehicleDetailsByStudentVehicleId(int vehicleId);
		
         //getStaffUserListByClassId
		List<Staff> getStaffUserListByClassId(Integer classId);

		List<Staff> getStaffUserListByCampusId(Integer campusId);

		List<Class> getAllClassesByCompusId(Integer campus_id);
         List<Books> getBookListByCampusId(Integer campusId);
         List<Student>getListOfStudentByCampusIdWhoHasTakenBooks(Integer campus_id,Integer BookId);

		List<Student> getStudentWhoHasReturnBook(Integer campus_id);

		DriverUser getdriverdetailsByID(Integer dId);

		List<DriverUser> getdriverdetailsByCampusID(Integer campusId);

		List<VehicleDetail> getVehicleListByCampusId(Integer campusId);

		List<VehicleDetail> getVehicleListByCampusIdDriverId(Integer campusId, Integer driverId);

		ExamDetails getExamById(Integer EttId);

		List<ExamDetails> getExamDetails();

		List<ExamClassMapping> getExamTimeTableByClassId(Integer classId);

		List<ClassTimeTable> getClassTimeTableByClassId(Integer classId);

		SchoolNews getSchoolNewsListBySchoolId(Integer id);

		School getSchoolListByCampusId(Integer id);

		com.sag.routes.model.MedicalDetails getMedicalDetailsById(Integer mid);

		List<com.sag.routes.model.MedicalDetails> getMedicalDetails();

		boolean MedicalExists(int id, int id2);

		void addMedical(com.sag.routes.model.MedicalDetails medical);

		

		void updateMedical(com.sag.routes.model.MedicalDetails medical);

		void deleteMedicalDetails(Integer id);

		void addStudentDetails(Student student);

		List<HolidayList> getHolidayListByCampusId(Integer campusId);

		HolidayList getHolidayListById(Integer hId);

		

		boolean routeExists(String source, String destination);

		Login getLoginDetailsById(Integer id);

		List<Login> getLoginDetails();

		List<CourseAssessment> getCourseAssessmentDetails(Integer courseId,Integer AssessmentId);

		List<Coursetable> getAllCoursesList();
		
		List<CourseGrades> getCourseGradeDetails(Integer courseId);

		List<Coursetable> getCourseDetailsById(Integer courseId);

		List<CourseMembership> getCourseMembersDetails(Integer user_id);

		void addCourseDetail(Coursetable coursetab);
		
		boolean CoursedataExists(int id, String name);

		List<Coursetable> getCourseTermDetailsById(Integer termId); 

		//List<CourseMembership> getCourseMembersDetails(Integer courseId, Integer AssessmentId);
		
		

		


}
