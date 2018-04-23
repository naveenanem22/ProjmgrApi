package com.pmt.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pmt.config.*;

public class ResourceRequest {
	private int rar_requestId;

	private Account rar_account;
	private Project rar_project;
	private String rar_status;
	private Resource rar_owner;
	private String rar_billable;
	
	private int rard_requestDetailId;
	private String rard_requestType;
	private String rard_role;
	private String rard_allocationType;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date rard_allcStartdate;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	private Date rard_allcEnddate;
	
	private String rard_clientInterview;
	private Skill rard_primarySkill;
	private Skill rard_secondarySkill;
	private Skill rard_domain;
	private String rard_comments;
	private Location rard_location;
	private String rard_status;
	private Resource rard_resProposed;
	private String rard_decision;
	private Resource rard_rmgApprover;
	private Resource rard_deliveryApprover;
	private String rard_allcType;
	private String rard_competencyGroup;
	
	
	public ResourceRequest() {
		
	}
	
	
	public int getRar_requestId() {
		return rar_requestId;
	}
	public void setRar_requestId(int rar_requestId) {
		this.rar_requestId = rar_requestId;
	}
	public Account getRar_account() {
		return rar_account;
	}
	public void setRar_account(Account rar_account) {
		this.rar_account = rar_account;
	}
	public Project getRar_project() {
		return rar_project;
	}
	public void setRar_project(Project rar_project) {
		this.rar_project = rar_project;
	}
	public String getRar_status() {
		return rar_status;
	}
	public void setRar_status(String rar_status) {
		this.rar_status = rar_status;
	}
	public Resource getRar_owner() {
		return rar_owner;
	}
	public void setRar_owner(Resource rar_owner) {
		this.rar_owner = rar_owner;
	}
	public String getRar_billable() {
		return rar_billable;
	}
	public void setRar_billable(String rar_billable) {
		this.rar_billable = rar_billable;
	}
	public int getRard_requestDetailId() {
		return rard_requestDetailId;
	}
	public void setRard_requestDetailId(int rard_requestDetailId) {
		this.rard_requestDetailId = rard_requestDetailId;
	}
	public String getRard_requestType() {
		return rard_requestType;
	}
	public void setRard_requestType(String rard_requestType) {
		this.rard_requestType = rard_requestType;
	}
	public String getRard_role() {
		return rard_role;
	}
	public void setRard_role(String rard_role) {
		this.rard_role = rard_role;
	}
	
	public String getRard_allocationType() {
		return rard_allocationType;
	}


	public void setRard_allocationType(String rard_allocationType) {
		this.rard_allocationType = rard_allocationType;
	}

	
	public Date getRard_allcStartdate() {
		return rard_allcStartdate;
	}
	public void setRard_allcStartdate(Date rard_allcStartdate) {
		this.rard_allcStartdate = rard_allcStartdate;
	}
	public Date getRard_allcEnddate() {
		return rard_allcEnddate;
	}
	public void setRard_allcEnddate(Date rard_allcEnddate) {
		this.rard_allcEnddate = rard_allcEnddate;
	}
	public String getRard_clientInterview() {
		return rard_clientInterview;
	}
	public void setRard_clientInterview(String rard_clientInterview) {
		this.rard_clientInterview = rard_clientInterview;
	}
	public Skill getRard_primarySkill() {
		return rard_primarySkill;
	}
	public void setRard_primarySkill(Skill rard_primarySkill) {
		this.rard_primarySkill = rard_primarySkill;
	}
	public Skill getRard_secondarySkill() {
		return rard_secondarySkill;
	}
	public void setRard_secondarySkill(Skill rard_secondarySkill) {
		this.rard_secondarySkill = rard_secondarySkill;
	}
	public Skill getRard_domain() {
		return rard_domain;
	}
	public void setRard_domain(Skill rard_domain) {
		this.rard_domain = rard_domain;
	}
	public String getRard_comments() {
		return rard_comments;
	}
	public void setRard_comments(String rard_comments) {
		this.rard_comments = rard_comments;
	}
	public Location getRard_location() {
		return rard_location;
	}
	public void setRard_location(Location rard_location) {
		this.rard_location = rard_location;
	}
	public String getRard_status() {
		return rard_status;
	}
	public void setRard_status(String rard_status) {
		this.rard_status = rard_status;
	}
	public Resource getRard_resProposed() {
		return rard_resProposed;
	}
	public void setRard_resProposed(Resource rard_resProposed) {
		this.rard_resProposed = rard_resProposed;
	}
	public String getRard_decision() {
		return rard_decision;
	}
	public void setRard_decision(String rard_decision) {
		this.rard_decision = rard_decision;
	}
	public Resource getRard_rmgApprover() {
		return rard_rmgApprover;
	}
	public void setRard_rmgApprover(Resource rard_rmgApprover) {
		this.rard_rmgApprover = rard_rmgApprover;
	}
	public Resource getRard_deliveryApprover() {
		return rard_deliveryApprover;
	}
	public void setRard_deliveryApprover(Resource rard_deliveryApprover) {
		this.rard_deliveryApprover = rard_deliveryApprover;
	}
	public String getRard_allcType() {
		return rard_allcType;
	}
	public void setRard_allcType(String rard_allcType) {
		this.rard_allcType = rard_allcType;
	}
	public String getRard_competencyGroup() {
		return rard_competencyGroup;
	}
	public void setRard_competencyGroup(String rard_competencyGroup) {
		this.rard_competencyGroup = rard_competencyGroup;
	}	
	
	
	
	

}
