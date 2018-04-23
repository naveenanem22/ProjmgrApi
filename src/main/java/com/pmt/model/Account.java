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
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ac_id")	
	private int id;
	
	@Column(name="ac_name")
	private String name;
	
	@Column(name="ac_desc")
	private String desc;
	
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ac_resourceid")
	private Resource manager;
	
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ac_businessunitid")
	private Businessunit businessunit;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="ac_deliveryunitid")
	private Deliveryunit deliveryunit;
	
	@Column(name="ac_startdate")
	private Date startDate;
	
	@Column(name="ac_enddate")
	private Date endDate;
	
	@Column(name="ac_domain")
	private String domain;
	
	@Column(name="ac_subdomain")
	private String subDomain;
	
	@Column(name="ac_contactperson")
	private String contactPerson;
	
	@Column(name="ac_status")
	private String status;
	
	@Column(name="ac_type")
	private String type;
		
	
	
		

		

		public Account(){
		
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
	
	
	public Resource getManager() {
		return manager;
	}
	public void setManager(Resource manager) {
		this.manager = manager;
	}
	
	public Businessunit getBusinessunit() {
		return businessunit;
	}

	public void setBusinessunit(Businessunit businessunit) {
		this.businessunit = businessunit;
	}

	public Deliveryunit getDeliveryunit() {
		return deliveryunit;
	}

	public void setDeliveryunit(Deliveryunit deliveryunit) {
		this.deliveryunit = deliveryunit;
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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



}
