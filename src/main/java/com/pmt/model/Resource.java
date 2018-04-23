package com.pmt.model;

import java.util.Date;



import java.util.List;
import java.util.Set;







import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
@Table(name="resource")
public class Resource {
	
	@Id
	@Column(name="res_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="res_empid")
	private int employeeId;
	
	@Column(name="res_firstname")
	private String firstName;
	
	@Column(name="res_lastname")
	private String lastName;
	
	@Column(name="res_contactnumber")
	private String contactNumber;
	
	@Column(name="res_email")
	private String email;	

	@JoinColumn(name="res_currentlocationid")
	@ManyToOne
	@Cascade ({CascadeType.PERSIST})
	private Location currLocation;
	
	@JoinColumn(name="res_permanentlocationid")
	@ManyToOne
	@Cascade ({CascadeType.PERSIST})
	private Location permLocation;
		
	@Column(name="res_designation")
	private String designation;
	
	@Column(name="res_doj")
	private Date doj;
	
	@Column(name="res_tier")
	private String tier;
	
	@Column(name="res_gender")
	private String gender;
	
	@Column(name="res_maritalStatus")
	private String maritalStatus;
	
	@Column(name="res_natureofemployment")
	private String natureOfEmployment;
	
	@Column(name="res_empstatus")
	private String empStatus;
	
	@Column(name="res_lastworkingday")
	private Date lastWorkingDay;
	
	@Column(name="res_contractstartdate")
	private Date contractStartDate;
	
	@Column(name="res_contractenddate")
	private Date contractEndDate;
	
	@Column(name="res_passportnumber")
	private String passportNumber;
	
	@Column(name="res_passportexpirydate")
	private Date passportExpiryDate;
	
	@Column(name="res_track")
	private String track;
	
	@Column(name="res_competencygroup")
	private String competencyGroup;
	
	@OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})	
	private Set<Certificate> certificates;
	
	@OneToMany(mappedBy="employee", fetch=FetchType.LAZY)
	@Cascade({CascadeType.ALL})	
	private Set<Visa> visas;
	
	
	


	public Resource(){
		
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

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Location getCurrLocation() {
		return currLocation;
	}
	public void setCurrLocation(Location currLocation) {
		this.currLocation = currLocation;
	}
	public Location getPermLocation() {
		return permLocation;
	}
	public void setPermLocation(Location permLocation) {
		this.permLocation = permLocation;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNatureOfEmployment() {
		return natureOfEmployment;
	}


	public void setNatureOfEmployment(String natureOfEmployment) {
		this.natureOfEmployment = natureOfEmployment;
	}


	public String getEmpStatus() {
		return empStatus;
	}


	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}


	public Date getLastWorkingDay() {
		return lastWorkingDay;
	}


	public void setLastWorkingDay(Date lastWorkingDay) {
		this.lastWorkingDay = lastWorkingDay;
	}


	public Date getContractStartDate() {
		return contractStartDate;
	}


	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}


	public Date getContractEndDate() {
		return contractEndDate;
	}


	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}


	public Date getPassportExpiryDate() {
		return passportExpiryDate;
	}


	public void setPassportExpiryDate(Date passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}
	
	public String getTrack() {
		return track;
	}


	public void setTrack(String track) {
		this.track = track;
	}


	public String getCompetencyGroup() {
		return competencyGroup;
	}


	public void setCompetencyGroup(String competencyGroup) {
		this.competencyGroup = competencyGroup;
	}
	
	public Set<Certificate> getCertificates() {
		return certificates;
	}


	public void setCertificates(Set<Certificate> certificates) {
		this.certificates = certificates;
	}
	
	public Set<Visa> getVisas() {
		return visas;
	}


	public void setVisas(Set<Visa> visas) {
		this.visas = visas;
	}
	
	





}
