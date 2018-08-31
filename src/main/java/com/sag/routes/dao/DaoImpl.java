package com.sag.routes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sag.routes.model.AttendanceUser;
import com.sag.routes.model.Books;
import com.sag.routes.model.BusDetails;
import com.sag.routes.model.CampusUser;
import com.sag.routes.model.Class;
import com.sag.routes.model.Course;
import com.sag.routes.model.DriverUser;
import com.sag.routes.model.Event;
import com.sag.routes.model.GuardianUser;
import com.sag.routes.model.LibrarianUser;
import com.sag.routes.model.Organization;
import com.sag.routes.model.Route;
import com.sag.routes.model.School;
import com.sag.routes.model.Staff;
import com.sag.routes.model.Student;
import com.sag.routes.model.TrainDetails;
import com.sag.routes.model.UserContext;
import com.sag.routes.model.VehicleDetail;


@Transactional
@Repository
public class DaoImpl implements Dao {

	/*Entity Manager is used to access a database 
	* it is used to create and remove persistent entity instances
	*to find entities by their primary key identity etc. 
	*This interface is similar to the Session in Hibernate
	*/
	@PersistenceContext
	private EntityManager entityManager;
	 private static SessionFactory factory;
	// Route DAO Implementation
	
	
	@Override
	public Route getRouteById(int routeId) {
		return entityManager.find(Route.class, routeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Route> getAllRoutes() {
		String hql = "FROM Route as rte ORDER BY rte.route_id";
		return (List<Route>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addRoute(Route route) {
		entityManager.persist(route);
	}

	@Override
	public void updateRoute(Route route) {
		Route rte = entityManager.find(Route.class, route.getRoute_id());
		rte.setSource(route.getSource());
		rte.setDestination(route.getDestination());
		entityManager.flush();
	}

	@Override
	public void deleteRoute(int routeId) {
		entityManager.remove(entityManager.find(Route.class, routeId));
	}

	@Override
	public boolean routeExists(String source, String destination) {
		String hql = "FROM Route as rte WHERE rte.source = ? and rte.destination = ?";
		int count = entityManager.createQuery(hql).setParameter(1, source).setParameter(2, destination).getResultList()
				.size();
		return count > 0;
	}

	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getBusRoute(String source, String destination) {
		System.out.println(source + destination);
		String hql = "select rte.source,rte.destination,bd.route_Num FROM Route as rte INNER JOIN rte.busroutedetails as brd INNER JOIN brd.busdetails as bd where rte.source = '"
				+ source.toLowerCase() + "' and rte.destination =  '" + destination.toLowerCase() + "'";
		return (List<Object>) entityManager.createQuery(hql).getResultList();

		

	}
	
	// Bus DAO Implementation
	
	@Override
	public BusDetails getBusDetailsById(int busDetailsId) {
		return entityManager.find(BusDetails.class, busDetailsId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusDetails> getAllBusDetails() {
		String hql = "FROM BusDetails as rte ORDER BY rte.busDetails_id";
		return (List<BusDetails>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public void addBusDetails(BusDetails busDetails) {
		entityManager.persist(busDetails);
	}

	@Override
	public void updateBusDetails(BusDetails busDetails) {
		BusDetails rte = entityManager.find(BusDetails.class, busDetails.getBusDetails_id());
		rte.setRoute_Num(busDetails.getRoute_Num());
		entityManager.flush();
	}

	@Override
	public void deleteBusDetails(int busDetailsId) {
		entityManager.remove(entityManager.find(BusDetails.class, busDetailsId));
	}

	@Override
	public boolean busDetailsExists(String route_Num) {
		String hql = "FROM BusDetails as rte WHERE rte.route_Num = ?";
		int count = entityManager.createQuery(hql).setParameter(1, route_Num).getResultList().size();
		return count > 0 ;
	}
	
	// TrainDetails  DAO Implementation
	
	
		@Override
		public TrainDetails getTrainDetailsById(int trainId) {
			return entityManager.find(TrainDetails.class, trainId);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<Object> getAllTrainDetails() {
			String hql = "select trn.source,trn.destination,trn.route,trn.time,trn.type FROM TrainDetails as trn ORDER BY trn.trainId";
			return (List<Object>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addTrainDetails(TrainDetails trainDetails) {
			entityManager.persist(trainDetails);
		}

		@Override
		public void updateTrainDetails(TrainDetails trainDetails) {
			TrainDetails trn = entityManager.find(TrainDetails.class, trainDetails.getTrainId());
			trn.setSource(trainDetails.getSource());
			trn.setDestination(trainDetails.getDestination());
			trn.setTime(trainDetails.getTime());
			trn.setRoute(trainDetails.getRoute());
			entityManager.flush();
		}

		@Override
		public void deleteTrainDetails(int trainId) {
			entityManager.remove(entityManager.find(TrainDetails.class, trainId));
		}

		@Override
		public boolean trainDetailsExists(String source, String destination,String route,long time,String type) {
			String hql = "FROM TrainDetails as trn WHERE trn.source = ? and trn.destination = ? and trn.route = ?and trn.time = ? and trn.type=?";
			int count = entityManager.createQuery(hql).setParameter(1, source).setParameter(2, destination).setParameter(3,route ).setParameter(4,time).setParameter(5, type).getResultList()
					.size();
			return count > 0;
		}

		
		/* Query for the function in PostgreSQL which is written in Hibernate and stored in 'hql'
		 * ----->SELECT source,destination,route_Num FROM route AS r INNER JOIN
		* busroute_details AS brd ON brd.route_id=r.route_id
		* INNER JOIN busdetails AS bd ON brd.busdetails_id=bd.busdetails_id
		* WHERE r.source='TNagar' AND r.destination='Thiruvanmiyur';
		*/
		
		@SuppressWarnings("unchecked")
		@Override
		public List<Object> getTrainRoute(String source, String destination) {
			System.out.println(source + destination);
			String hql = "select trn.source,trn.destination,trn.route,trn.time,trn.type FROM TrainDetails as trn where trn.source = '"
					+ source.toLowerCase() + "' and trn.destination =  '" + destination.toLowerCase() + "'";
			return (List<Object>) entityManager.createQuery(hql).getResultList();

			

		}

		@Override
		public Student getStudentById(int id) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, id);
		}

		@Override
		public List<Student> getAllStudents() {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu ORDER BY stu.sdId";
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		@Transactional
		public void addStudent(Student student) {
			// TODO Auto-generated method stub
		
			
			//persist example - with transaction
			
			//entityManager.getTransaction().begin();
			/*Student stud=new Student();
			stud.setSdId(40);*/
			System.out.println("Saving Employee to Database");
			
			entityManager.merge(student);
			
			System.out.println("Generated Employee ID = " + student.getSdId());
			/*Student stud=entityManager.find(Student.class, student.getSdId());
			stud.setBookId(student);*/
			
			/*Student stu = entityManager.merge(student);
			stu.setSdId(student.getSdId());
			stu.setUser_id(student.getUser_id());
			stu.setStudentadminno(student.getUser_id());
			stu.setVehicleId(stu.getVehicleId());*/
			
			entityManager.flush();
		}
			
		

		@Override
		public void updateStudent(Student student) {
			// TODO Auto-generated method stub
			Student stu = entityManager.find(Student.class, student.getSdId());
			stu.setSdId(student.getSdId());
			stu.setUser_id(student.getUser_id());
			entityManager.flush();
		}
		@Override
		public boolean studentExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu WHERE stu.sdId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		

		@Override
		public void deleteStudent(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Student.class, id));
		}

		@Override
		public Staff getstaffById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(Staff.class, id);
		}

		@Override
		public List<Staff> getAllstaffs() {
			// TODO Auto-generated method stub
			String hql = "FROM Staff as staf ORDER BY staf.id";
			return (List<Staff>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addStaff(Staff staff) {
			// TODO Auto-generated method stub
			entityManager.persist(staff);
		}

		@Override
		public void updatestaff(Staff staff) {
			// TODO Auto-generated method stub
			Staff staf = entityManager.find(Staff.class, staff.getId());
			staf.setId(staf.getId());
			staf.setUser_id(staf.getUser_id());
			entityManager.flush();
		}
		@Override
		public boolean staffExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM Staff as staf WHERE staf.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		//StaffsDetails

		@Override
		public void deletestaff(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Staff.class, id));
		}

		
		//GuardianDetails
		@Override
		public GuardianUser getGuardianById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(GuardianUser.class, id);
		}

		@Override
		public List<GuardianUser> getAllGuardians() {
			// TODO Auto-generated method stub
			String hql = "FROM GuardianUser as guardian ORDER BY guardian.id";
			return (List<GuardianUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean guardianExists(int id, int userid)
		{
			// TODO Auto-generated method stub
			String hql = "FROM Guardian as guardian WHERE guardian.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addGuardian(GuardianUser guardian) {
			// TODO Auto-generated method stub
			entityManager.persist(guardian);
		}

		@Override
		public void updateGuardian(GuardianUser guardian) {
			// TODO Auto-generated method stub
			GuardianUser guardians = entityManager.find(GuardianUser.class, guardian.getgId());
			guardians.setgId(guardians.getgId());
			guardians.setUser_id(guardians.getUser_id());
			entityManager.flush();
		}

		@Override
		public void deleteGuardian(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(GuardianUser.class, id));
		}

		@Override
		public LibrarianUser getLibrarianById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(LibrarianUser.class, id);
		}
		

		@SuppressWarnings("unchecked")
		@Override
		public List<LibrarianUser> getAllLibrarians() {
			// TODO Auto-generated method stub
			String hql = "FROM LibrarianUser as librarian ORDER BY librarian.libId";
			return (List<LibrarianUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean librarianExists(int id, int userid) {
			// TODO Auto-generated method stub
			String hql = "FROM LibrarainUser as librarian WHERE librarian.libId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addLibrarian(LibrarianUser librarian) {
			// TODO Auto-generated method stub
			entityManager.persist(librarian);
		}

		@Override
		public void updateLibrarian(LibrarianUser librarian) {
			// TODO Auto-generated method stub
			LibrarianUser librarians = entityManager.find(LibrarianUser.class, librarian.getLibId());
			librarians.setLibId(librarians.getLibId());
			librarians.setUser_Id(librarians.getUser_Id());
			entityManager.flush();
		}

		@Override
		public void deleteLibrarian(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(LibrarianUser.class, id));
		}

		//Organization
		
		@Override
		public Organization getOrganizationById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(Organization.class, id);
		}

		@Override
		public List<Organization> getAllOrganization() {
			// TODO Auto-generated method stub
			String hql = "FROM Organization as organization ORDER BY organization.oId";
			return (List<Organization>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean organizationExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Organization as organization WHERE organization.oId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addOrganization(Organization organization) {
			// TODO Auto-generated method stub
			entityManager.persist(organization);
		}

		@Override
		public void updateOrganization(Organization organization) {
			// TODO Auto-generated method stub
			Organization organizations = entityManager.find(Organization.class, organization.getoId());
			organizations.setoId(organizations.getoId());
			organizations.setName(organizations.getName());
			entityManager.flush();
		}

		@Override
		public void deleteOrganization(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Organization.class, id));
		}

		@Override
		public School getSchoolById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(School.class, id);
		}

		@Override
		public List<School> getAllSchool() {
			// TODO Auto-generated method stub
			String hql = "FROM School as school ORDER BY school.id";
			return (List<School>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addSchool(School school) {
			// TODO Auto-generated method stub
			entityManager.persist(school);
		}

		@Override
		public boolean schoolExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM School as school WHERE school.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void updateSchool(School school) {
			// TODO Auto-generated method stub
			School schools = entityManager.find(School.class, school.getId());
			schools.setId(schools.getId());
			schools.setCampus_ID(schools.getCampus_ID());
			entityManager.flush();
		}

		@Override
		public void deleteSchool(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(School.class, id));
			
		}

		@Override
		public CampusUser getCampusById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(CampusUser.class, id);
		}

		@Override
		public List<CampusUser> getAllCampuses() {
			// TODO Auto-generated method stub
			String hql = "FROM CampusUser as campus ORDER BY campus.cmId";
			return (List<CampusUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean CampusExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM CampusUser as campus WHERE campus.cmId = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addCampus(CampusUser campus) {
			// TODO Auto-generated method stub
			entityManager.persist(campus);
		}

		@Override
		public void updateCampus(CampusUser campus) {
			// TODO Auto-generated method stub
			CampusUser campuses = entityManager.find(CampusUser.class, campus.getCmId());
			campuses.setCmId(campuses.getCmId());
			campuses.setCampus_name(campuses.getCampus_name());
			entityManager.flush();
		}
		@Override
		public void deleteCampus(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(CampusUser.class, id));
			
		}

		@Override
		public Class getClassById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(com.sag.routes.model.Class.class, id);
		}

		@SuppressWarnings("unchecked")
		@Override
		public List<com.sag.routes.model.Class> getAllClasses() {
			// TODO Auto-generated method stub
			String hql = "FROM Class as clas ORDER BY clas.id";
			return (List<com.sag.routes.model.Class>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public boolean ClassExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Class as clas WHERE clas.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void addClass(com.sag.routes.model.Class class1) {
			// TODO Auto-generated method stub
			entityManager.persist(class1);
		}

		@Override
		public void updateClass(com.sag.routes.model.Class class1) {
			// TODO Auto-generated method stub
			Class classes = entityManager.find(Class.class, class1.getId());
			classes.setId(classes.getId());
			classes.setClass_name(classes.getClass_name());
			entityManager.flush();
		}

		@Override
		public void deleteClass(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Class.class, id));
		}

		@Override
		public Course getCourseById(Integer id) {
			// TODO Auto-generated method stub
			return entityManager.find(Course.class, id);
		}

		@Override
		public List<Course> getAllCourses() {
			// TODO Auto-generated method stub
			String hql = "FROM Course as course ORDER BY course.id";
			return (List<com.sag.routes.model.Course>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public void addCourse(Course course) {
			// TODO Auto-generated method stub
			entityManager.persist(course);
		}

		@Override
		public boolean CourseExists(int id, int id2) {
			// TODO Auto-generated method stub
			String hql = "FROM Class as class WHERE class.id = ?";
			int count = entityManager.createQuery(hql).setParameter(1, id).getResultList().size();
			return count > 0 ;
		}

		@Override
		public void updateCourse(Course course) {
			// TODO Auto-generated method stub
			Course courses = entityManager.find(Course.class, course.getId());
			courses.setId(courses.getId());
			courses.setName(courses.getName());
			entityManager.flush();
		}

		@Override
		public void deleteCourse(Integer id) {
			// TODO Auto-generated method stub
			entityManager.remove(entityManager.find(Course.class, id));
		}

		@Override
		public AttendanceUser CreateAttendance(int stuid, int classid) {
			// TODO Auto-generated method stub
			AttendanceUser attendance=entityManager.find(AttendanceUser.class, classid);
			attendance.setStud_id(stuid);
			attendance.setId(classid);
			return attendance;
		}

		@Override
		public UserContext createUserContext(int id, int id2) {
			// TODO Auto-generated method stub
	UserContext user=entityManager.find(UserContext.class,id );
	user.setContextId(id);
	user.setId(id2);
	user.setUserId(id);
	return user;
		}

		@Override
		public AttendanceUser getAttendance(int stud_id, int class_id) {
			// TODO Auto-generated method stub
			return entityManager.find(AttendanceUser.class, stud_id);
		}

		@Override
		public List<AttendanceUser> getAttendanceList(int stud_id) {
			// TODO Auto-generated method stub
			String hql = "FROM AttendanceUser as attend where attend.stud_id="+stud_id;
			return (List<AttendanceUser>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentListByCampusId(Integer cmId) {
			// TODO Auto-generated method stub
			//return entityManager.find(Student.class, cmId);
			String hql = "FROM Student as stu where stu.cmId="+cmId;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentListByClassId(int  classId) {
			// TODO Auto-generated method stub
			String hql = "FROM Student as stu where stu.classId="+classId;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public Student getStudentVehicleDetailsByStudentAdmNum(
				Integer stdadmissionno) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, stdadmissionno);
		}

		@Override
		public Student getStdUserByStdAdmissionNumber(Integer Studentadminno) {
			// TODO Auto-generated method stub
			return entityManager.find(Student.class, Studentadminno);
		}

		@Override
		public List<Event> getStudentEventDetailsByStudentUserId(int studentUserId) {
			// TODO Auto-generated method stub
			String hql = "FROM Event as evn where evn.studentUserId="+studentUserId;
			return (List<Event>) entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Student> getStudentDetailByStdAdmNum(Integer stdadmissionno) {
			
			String hql = "FROM Student as stud where stud.stdadmissionno="+stdadmissionno;
			return (List<Student>) entityManager.createQuery(hql).getResultList();
			}

		@Override
		public VehicleDetail getStudentVehicleDetailsByStudentVehicleId(
				int vehicleId) {
			// TODO Auto-generated method stub
			return entityManager.find(VehicleDetail.class, vehicleId);
		}
		

		@Override
		public List< Staff> getStaffUserListByClassId(Integer classId) {
			String hql="FROM Staff as staff where staff.classId="+classId;
			return (List<Staff>) entityManager.createQuery(hql).getResultList();
		}

		

		@Override
		public List<Staff> getStaffUserListByCampusId(Integer campusId) {
			String hql="From Staff as staff where staff.campusId="+campusId;
			return (List<Staff>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public List<Class> getAllClassesByCompusId(Integer campus_id) {
			// TODO Auto-generated method stub
			String hql="From Class as class where class.campus_id="+campus_id;
			return (List<Class>)entityManager.createQuery(hql).getResultList();
		}

		
		//getListOfStudentByCampusIdWhoHasTakenBooks
		@Override
		public List<Student> getListOfStudentByCampusIdWhoHasTakenBooks(Integer campus_id,Integer bookId) {
			// TODO Auto-generated method stub
			String hql="select stu.sdId,stu.user_id,stu.Studentadminno,stu.vehicleId,stu.eventId,stu.documentsSubmitted,stu.religionId,stu.motherTongueId,stu.categoryId,stu.nationalityId,stu.classId FROM Student as stu where stu.cmId = '"
					+ campus_id + "' and stu.bookId =  '" + bookId+ "'";
			return (List<Student>)entityManager.createQuery(hql).getResultList();
		}
	
		
		
		@Override
		public List<Books> getBookListByCampusId(Integer campusId) {
			String hql="From Books as book where book.campusId="+campusId;
			return (List<Books>)entityManager.createQuery(hql).getResultList();
	 }
	 
		@Override
		public List<Student> getStudentWhoHasReturnBook(Integer campus_id) {
			// TODO Auto-generated method stub
			String hql="From Books as book where book.campus_id="+campus_id;
			return (List<Student>)entityManager.createQuery(hql).getResultList();
		}

		@Override
		public DriverUser getdriverdetailsByID(Integer dId) {
			// TODO Auto-generated method stub
			return entityManager.find(DriverUser.class, dId);
		}
	
		
		

		

		
	
}
