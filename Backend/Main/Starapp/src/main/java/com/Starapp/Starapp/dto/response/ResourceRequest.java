package com.Starapp.Starapp.dto.response;


import java.util.List;

import com.Starapp.Starapp.Entities.RequestChangeLog;

import lombok.Data;

@Data
public class ResourceRequest {
	private Integer key;
	private Long workingHourId;
	private String timesheetNo;
	private String projectName;
	private String startTime;
	private String endTime;
	private String managerName;
	private String status;
	private Integer extraHours;
	List<RequestChangeLog> requestLogs;
}
