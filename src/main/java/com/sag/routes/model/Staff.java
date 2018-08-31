package com.sag.routes.model;

import javax.persistence.*;

@Entity
@Table(name = "STAFF_DETAILS")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    
    
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "vehicleId")
    private String vehicleId;

    @Column(name = "staffUniqueId")
    private String staffUniqueId;

    @Column(name = "staffTeacherClassId")
    private String staffTeacherClassId;
   
    @Column(name = "documentsSubmitted")
    private String documentsSubmitted;
    
    @Column(name = "religionId")
    private String religionId;
    
    @Column(name = "motherTongueId")
    private String motherTongueId; 
    
    @Column(name = "categoryId")
    private String categoryId;  
    
    @Column(name = "nationalityId")
    private String nationalityId;
    
    
    @Column(name = "campusId")
    private int  campusId;
    
    @Column(name = "classId")
    private int  classId;
    
	public int getCampusId() {
		return campusId;
	}

	public void setCampusId(int campusId) {
		this.campusId = campusId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getStaffUniqueId() {
		return staffUniqueId;
	}

	public void setStaffUniqueId(String staffUniqueId) {
		this.staffUniqueId = staffUniqueId;
	}

	public String getStaffTeacherClassId() {
		return staffTeacherClassId;
	}

	public void setStaffTeacherClassId(String staffTeacherClassId) {
		this.staffTeacherClassId = staffTeacherClassId;
	}

	public String getDocumentsSubmitted() {
		return documentsSubmitted;
	}

	public void setDocumentsSubmitted(String documentsSubmitted) {
		this.documentsSubmitted = documentsSubmitted;
	}

	public String getReligionId() {
		return religionId;
	}

	public void setReligionId(String religionId) {
		this.religionId = religionId;
	}

	public String getMotherTongueId() {
		return motherTongueId;
	}

	public void setMotherTongueId(String motherTongueId) {
		this.motherTongueId = motherTongueId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}  
    
    
    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="course")
    private Course course;

    public Staff() {
    }

    public Staff(String firstName, String lastName, String email, Address address) {
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
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                //", course=" + course +
                '}';
    }*/
}

