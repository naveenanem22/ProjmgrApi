package com.pmt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="certificate")
public class Certificate {
	
    @Id
    @Column(name="cer_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    
   
	@Column(name="cer_name")
	private String name;
    
    @Column(name="cer_certifyingorg")
	private String certifyingOrg;
    
    @Column(name="cer_grade")
	private String grade;
    
    @Column(name="cer_percentage")
	private String percentage;
    
    @Column(name="cer_validtill")
	private Date validTill;
    
    @Column(name="cer_certdate")
    private Date certDate;
    
    
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cer_resourceid")
	private Resource employee;
	
	
	public Certificate(){
		
	}
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertifyingOrg() {
		return certifyingOrg;
	}
	public void setCertifyingOrg(String certifyingOrg) {
		this.certifyingOrg = certifyingOrg;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public Date getValidTill() {
		return validTill;
	}
	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}
	
	public Date getCertDate() {
		return certDate;
	}
	public void setCertDate(Date certDate) {
		this.certDate = certDate;
	}
	
	public Resource getEmployee() {
		return employee;
	}
	public void setEmployee(Resource employee) {
		this.employee = employee;
	}
	

}
