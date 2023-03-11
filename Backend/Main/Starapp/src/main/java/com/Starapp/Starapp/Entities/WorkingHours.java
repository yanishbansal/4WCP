package com.Starapp.Starapp.Entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class WorkingHours {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long workingHourId;
    private String timesheetNo;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private Integer hours;
    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;
    @Column(columnDefinition = "boolean default false")
    private Boolean isApproved;
    private String responseText;
    @CreationTimestamp
    private LocalDateTime createdOn;
    private LocalDateTime approvedOn;
    
  //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "projId", referencedColumnName="projectId")
  	@JsonBackReference
  	private Project project;
  //foreign key
  	@ManyToOne(cascade = CascadeType.ALL)	
  	@JoinColumn(name = "resourceId", referencedColumnName="userId")
  	@JsonBackReference
  	private User user;
  	
	
	@OneToMany(mappedBy = "logId")
	@JsonManagedReference
	private List<RequestChangeLog> changeLogs;
  	
}
