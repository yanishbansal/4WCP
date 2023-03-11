package com.Starapp.Starapp.dto.response;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ManagerRequest {
	private Long id; 
	private Long userId;
	private String timesheetNo;
	private String name;
	private String projectName;	
	//
	private String periodStart;
	//
	private String periodEnd;
	private Integer hours;
	private Integer expectedHours;		
}
