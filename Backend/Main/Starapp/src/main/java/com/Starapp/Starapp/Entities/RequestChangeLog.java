package com.Starapp.Starapp.Entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class RequestChangeLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long logId;
	String responseText;
	LocalDateTime updatedOn;
	Boolean isApproved;
	
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "timesheetId", referencedColumnName="workingHourId")
  	@JsonBackReference
  	private WorkingHours timesheet;
}
