package com.pmt.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@Column(name="prj_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="prj_name")
	private String name;
	
	@Column(name="prj_desc")
	private String desc;
	
	@Column(name="prj_type")
	private String type;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="prj_locationid")
	private Location location;
	
	@Column(name="prj_projectstartdate")
	private Date startDate;
	
	@Column(name="prj_projectenddate")
	private Date endDate;
	
	@Column(name="prj_contracttype")
	private String contractType;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="prj_resourceid")
	private Resource manager;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="prj_accountid")
	private Account account;	
	
	@Column(name="prj_status")
	private String status;
	
	
	
	
	


	public Project(){
		
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Resource getManager() {
		return manager;
	}

	public void setManager(Resource manager) {
		this.manager = manager;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
		

}
