package com.sag.routes.service;

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
import com.sag.routes.model.RouteDTO;
import com.sag.routes.model.School;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.StudentClassMapping;
import com.sag.routes.model.TrainDetailDTO;
import com.sag.routes.model.TrainDetails;
import com.sag.routes.model.VehicleDetail;

import blackboard.data.course.CourseMembership;

// Service Interface

public interface ServiceI {

	// Route Service
	// Get all available routes
	
	List<Route> getAllRoutes();
// Get routes based on ID
  Route getRouteById(int routeId);

// Get Bus route number for given source and destination
	public List<RouteDTO> getBusRoute(String source, String destination);

	boolean addRoute(Route route);

	void updateRoute(Route route);

	void deleteRoute(int routeId);

	// Bus Service
	
	// Get all available bus number
	List<BusDetails> getAllBusDetails();

	// Get bus number based on ID
	BusDetails getBusDetailsById(int busDetailsId);

	boolean addBusDetails(BusDetails busDetails);

	void updateBusDetails(BusDetails busDetails);

	void deleteBusDetails(int busDetailsId);
	
	
	
	// Train Service
	
	// Get all available TrainDetails
	   public List<TrainDetailDTO> getAllTrainDetails();

		// Get trainDetails based on ID
		TrainDetails getTrainDetailsById(int trainId);

		// Get Train route for given source and destination
		public List<TrainDetailDTO> getTrainRoute(String source, String destination);

		boolean addTrainDetails(TrainDetails trainDetails);

		void updateTrainDetails(TrainDetails trainDetails);

		void deleteTrainDetails(int trainId);

		
		
		
		
		//StudentDetails
		
		public Student getStudentById(int id);

		List<Student> getAllStudents();

		boolean addStudent(Student student);

		void updateStudent(Student student);

		void deleteStudent(Integer id);

		
		
		//StaffDetails
		
		Staff getstaffById(Integer id);

		List<Staff> getAllstaffs();

		boolean addstaff(Staff staff);

		void updatestaff(Staff staff);

		void deletestaff(Integer id);
		
		
		//GuardianDetails

		GuardianUser getGuardianById(Integer id);

		List<GuardianUser> getAllGuardians();

		boolean addGuardian(GuardianUser guardian);

		void updateGuardian(GuardianUser guardian);

		void deleteGuardian(Integer id);

		LibrarianUser getLibrarianById(Integer id);

		List<LibrarianUser> getAllLibrarians();

		boolean addLibrarian(LibrarianUser librarian);

		void updateLibrarian(LibrarianUser librarian);

		void deleteLibrarian(Integer id);

		Organization getOrganizationById(Integer id);

		List<Organization> getAllOrganization();

		boolean addOrganization(Organization organization);

		void updateOrganization(Organization organization);

		void deleteOrganization(Integer id);

		School getSchoolById(Integer id);

		List<School> getAllSchool();

		boolean addSchool(School school);

		void updateSchool(School school);

		void deleteSchool(Integer id);

		CampusUser getCampusById(Integer id);

		List<CampusUser> getAllCampuses();

		boolean addCampus(CampusUser campus);

		void updateCampus(CampusUser campus);

		void deleteCampus(Integer id);

		com.sag.routes.model.Class getClassById(Integer id);

		List<Class> getAllClasses();

		boolean addClass(Class class1);

		void updateClass(Class class1);

		void deleteClass(Integer id);

		Course getCourseById(Integer id);

		List<Course> getAllCourses();

		boolean addCourse(Course course);

		void updateCourse(Course course);

		void deleteCourse(Integer id);

		void createattendanceList(int stuid,int classid);

		void createUserContext(int id, int id2);

		void getattendanceList(int stud_id, int class_id);

	    List<AttendanceUser> getattendanceList(int stud_id);

		List<Student> getStudentUserListByCampusId(Integer stud_id);

		List<Student> getStudentListByClassId(Integer classId);

		Student getStudentVehicleDetailsByStudentAdmNum(Integer stdadmissionno);

		Student getStdUserByStdAdmissionNumber(Integer stdadmissionno);

		List<Event > getStudentEventDetailsByStudentUserId(int studUserId);

		VehicleDetail getStudentVehicleDetailsByStudentVehicleId(int vehicleId);

		List<Student> getStudentDetailByStdAdmNum(Integer stdadmissionno);

		List<Staff >getStaffUserListByClassId(Integer classId);
		
		List<Staff> getStaffUserListByCampusId(Integer campusId);
		
		List<Class> getAllClassesByCompusId(Integer campus_id);
		
		List<Books>getBookListByCampusId(Integer campusId );
		
		List<Student>getListOfStudentByCampusIdWhoHasTakenBooks(Integer campus_id,Integer BookId);

		List <Student>getStudentWhoHasReturnBook(Integer campusId);
		DriverUser getdriverdetailsByID(Integer dId);
		
		List<DriverUser> getdriverdetailsByCampusID(Integer campusId);
		
		List<VehicleDetail> getVehicleListByCampusId(Integer campusId);
		
		List<VehicleDetail> getVehicleListByCampusIdDriverId(Integer campusId, Integer driverId);
		
		ExamDetails getExamById(Integer EttId);
		
		List<ExamDetails> getExamDetails();
		
		List<ExamClassMapping> getExamTimeTableByClassId(Integer classId);
		
		List<ClassTimeTable> getClassTimeTableByClassId(Integer classId);
		
		void getSchoolNewsListBySchoolId(Integer id);
		
		void getSchoolListByCampusId(Integer id);
		
		com.sag.routes.model.MedicalDetails getMedicalDetailsById(Integer mid);
		
		List<com.sag.routes.model.MedicalDetails> getMedicalDetails();
		
		boolean addMedicalDetails(com.sag.routes.model.MedicalDetails medical);
		
		void updateMedical(com.sag.routes.model.MedicalDetails medical);
		
		void deleteMedical(Integer id);
		
		Student save(Student student);
		
		List<HolidayList> getHolidayListByCampusId(Integer campusId);
		
        HolidayList getHolidayListById(Integer hId);
        
		Login getLoginById(Integer id);
		
		List<Login> getAllLogins();
		
		List<Coursetable> getCourseDetailsById(Integer courseId);
		
		List<CourseAssessment> getCourseAssessmentDetails(Integer courseId,Integer assessmentId);
		
		 List< Coursetable>  getAllCoursesList();
		 
		//List<CourseAssessment> getCourseGradeDetails(Integer courseId, Integer assessmentId);
		
		
		List<CourseGrades> getCourseGradeDetails(Integer courseId);
		
		List<CourseMembership> getCourseMembersDetails(Integer user_id);
		
		boolean addCourse(Coursetable coursetab);
		
		List<Coursetable> getCourseTermDetailsById(Integer termId);
		
		
}
