package com.Starapp.Starapp.Entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class WorkingHoursArchieve {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long workingHourArchieveId;  	
  	private String timesheetNo;
    private LocalDateTime periodStart;
    private LocalDateTime periodEnd;
    private String projectId;
    private Long resourceId;
 	private Integer hours;
   	private Boolean isActive;
   	private LocalDateTime createdOn;
   	private Boolean isApproved;
	
}
