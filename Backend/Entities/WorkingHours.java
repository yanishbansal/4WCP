package com.Starapp.Starapp.Entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class WorkingHours {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int workingHourId;
	
    int timesheetNo;
    LocalDateTime periodStart;
    LocalDateTime periodEnd;
    
  //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "projId", referencedColumnName="projectId")
  	Project project;
  //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "resourceId", referencedColumnName="userId")
  	User user;
  	
  	int hours;
  	Boolean isActive;
  	LocalDateTime createdOn;
  	Boolean isApproved;
  	
	public int getWorkingHourId() {
		return workingHourId;
	}
	public void setWorkingHourId(int workingHourId) {
		this.workingHourId = workingHourId;
	}
	public int getTimesheetNo() {
		return timesheetNo;
	}
	public void setTimesheetNo(int timesheetNo) {
		this.timesheetNo = timesheetNo;
	}
	public LocalDateTime getPeriodStart() {
		return periodStart;
	}
	public void setPeriodStart(LocalDateTime periodStart) {
		this.periodStart = periodStart;
	}
	public LocalDateTime getPeriodEnd() {
		return periodEnd;
	}
	public void setPeriodEnd(LocalDateTime periodEnd) {
		this.periodEnd = periodEnd;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public WorkingHours(int workingHourId, int timesheetNo, LocalDateTime periodStart, LocalDateTime periodEnd,
			Project project, User user, int hours, Boolean isActive, LocalDateTime createdOn, Boolean isApproved) {
		super();
		this.workingHourId = workingHourId;
		this.timesheetNo = timesheetNo;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.project = project;
		this.user = user;
		this.hours = hours;
		this.isActive = isActive;
		this.createdOn = createdOn;
		this.isApproved = isApproved;
	}
	@Override
	public String toString() {
		return "WorkingHours [workingHourId=" + workingHourId + ", timesheetNo=" + timesheetNo + ", periodStart="
				+ periodStart + ", periodEnd=" + periodEnd + ", project=" + project + ", user=" + user + ", hours="
				+ hours + ", isActive=" + isActive + ", createdOn=" + createdOn + ", isApproved=" + isApproved + "]";
	}
  	
  	
  	
  	
    
	
}
