package com.sag.routes.model;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_DETAILS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sdId;

    @Column(name = "user_id")
    private int user_id;
    
    @Column(name = "Studentadminno")
    private int Studentadminno;

    @Column(name = "vehicleId")
    private int vehicleId;

    @Column(name = "eventId")
    private int eventId;
    
    @Column(name = "documentsSubmitted")
    private String documentsSubmitted;

    @Column(name = "religionId")
    private int religionId;
    
    @Column(name = "motherTongueId")
    private int motherTongueId;
    
    @Column(name = "categoryId")
    private int categoryId;
    
    @Column(name = "nationalityId")
    private int nationalityId;
    
    @Column(name = "cmId")
    private int cmId; 
    
    @Column(name = "classId")
    private int classId;
    
    @Column(name = "bookId")
    private int bookId;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getCmId() {
		return cmId;
	}

	public void setCmId(int cmId) {
		this.cmId = cmId;
	}

	public int getSdId() {
		return sdId;
	}

	public void setSdId(int sdId) {
		this.sdId = sdId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	

	public int getStudentadminno() {
		return Studentadminno;
	}

	public void setStudentadminno(int studentadminno) {
		Studentadminno = studentadminno;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDocumentsSubmitted() {
		return documentsSubmitted;
	}

	public void setDocumentsSubmitted(String documentsSubmitted) {
		this.documentsSubmitted = documentsSubmitted;
	}

	public int getReligionId() {
		return religionId;
	}

	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}

	public int getMotherTongueId() {
		return motherTongueId;
	}

	public void setMotherTongueId(int motherTongueId) {
		this.motherTongueId = motherTongueId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}
    
    
}
    
    /*public int getSdId() {
		return sdId;
	}

	public void setSdId(int sdId) {
		this.sdId = sdId;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getStudentadminno() {
		return Studentadminno;
	}

	public void setStudentadminno(String studentadminno) {
		Studentadminno = studentadminno;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setReligionId(int religionId) {
		this.religionId = religionId;
	}

	public void setMotherTongueId(int motherTongueId) {
		this.motherTongueId = motherTongueId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setNationalityId(int nationalityId) {
		this.nationalityId = nationalityId;
	}

	

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course")
    private Course course;

    public Student() {
    }

    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                //", course=" + course +
                '}';
    }
}
*/
