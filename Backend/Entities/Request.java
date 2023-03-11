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
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int requestId;
  //foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerId", referencedColumnName="userId")
	User manageruser;
  //foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resourceId" , referencedColumnName = "userId")
	User resourceuser;
  //foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "workingId" , referencedColumnName = "workingHourId")
	WorkingHours workinghours;	
	
	Boolean isApproved;
	String responseText;
	LocalDateTime time;
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public User getManageruser() {
		return manageruser;
	}
	public void setManageruser(User manageruser) {
		this.manageruser = manageruser;
	}
	public User getResourceuser() {
		return resourceuser;
	}
	public void setResourceuser(User resourceuser) {
		this.resourceuser = resourceuser;
	}
	public WorkingHours getWorkinghours() {
		return workinghours;
	}
	public void setWorkinghours(WorkingHours workinghours) {
		this.workinghours = workinghours;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	public String getResponseText() {
		return responseText;
	}
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public Request(int requestId, User manageruser, User resourceuser, WorkingHours workinghours, Boolean isApproved,
			String responseText, LocalDateTime time) {
		super();
		this.requestId = requestId;
		this.manageruser = manageruser;
		this.resourceuser = resourceuser;
		this.workinghours = workinghours;
		this.isApproved = isApproved;
		this.responseText = responseText;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", manageruser=" + manageruser + ", resourceuser=" + resourceuser
				+ ", workinghours=" + workinghours + ", isApproved=" + isApproved + ", responseText=" + responseText
				+ ", time=" + time + "]";
	}
	
	


}
