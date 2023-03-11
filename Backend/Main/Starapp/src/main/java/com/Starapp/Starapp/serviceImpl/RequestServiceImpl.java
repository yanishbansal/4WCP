package com.Starapp.Starapp.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Starapp.Starapp.Entities.RequestChangeLog;
import com.Starapp.Starapp.Entities.WorkingHours;
import com.Starapp.Starapp.dto.request.OvertimeRequest;
import com.Starapp.Starapp.dto.response.ManagerRequest;
import com.Starapp.Starapp.dto.response.RequestHistory;
import com.Starapp.Starapp.dto.response.ResourceRequest;
import com.Starapp.Starapp.repo.RequestLogRepository;
import com.Starapp.Starapp.repo.UserProjectRelationRepository;
import com.Starapp.Starapp.repo.UserRepository;
import com.Starapp.Starapp.repo.WorkingHoursRepository;
import com.Starapp.Starapp.service.RequestService;
import org.springframework.http.HttpStatus;
import java.time.temporal.ChronoUnit;

@Service
public class RequestServiceImpl implements RequestService{
	@Autowired
	WorkingHoursRepository workRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserProjectRelationRepository userProjectRelation;
	
	@Autowired
	RequestLogRepository logRepo;

	String format = "dd-MMM-yy";
	@Override
	public List<ManagerRequest> getAllResourceRequestForManager(String email) {
		Long id = userRepo.findByEmail(email).orElse(null).getUserId();
  		List<ManagerRequest> data = new ArrayList<>();
  		List<WorkingHours> workingHours = workRepo.WorkingHoursOfResourcesForManagerId(id); 
  		for (WorkingHours employeeWH: workingHours) {
  			Long resourceId = employeeWH.getUser().getUserId();
  			String projectId = employeeWH.getProject().getProjectId();
  			Integer expectedHour = userProjectRelation.getExpectedWorkingHourOfResource(resourceId, projectId);
  			if (employeeWH.getHours() > expectedHour) {
  				ManagerRequest user = new ManagerRequest();
  				user.setId(employeeWH.getWorkingHourId());
  				user.setUserId(resourceId);
  				user.setTimesheetNo(employeeWH.getTimesheetNo());
  				user.setName(employeeWH.getUser().getName());
  				user.setProjectName(employeeWH.getProject().getProjectName());
  				//
  				LocalDateTime PeriodStart = employeeWH.getPeriodStart();
  				DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
				user.setPeriodStart( DateTimeFormatter.ofPattern(format)
  	  				  .format(PeriodStart));
  				
  				LocalDateTime PeriodEnd = employeeWH.getPeriodEnd();
				user.setPeriodEnd(DateTimeFormatter.ofPattern(format)
    	  				  .format(PeriodEnd));
  		    	user.setHours(employeeWH.getHours());
  				user.setExpectedHours(expectedHour);
  				data.add(user);
  			}
  		}
  		return data;
	}

	@Override
	public List<ResourceRequest> getAllResourceRequest(String email) {
		Integer key = 1;
		Long id = userRepo.findByEmail(email).orElse(null).getUserId();
  		List<ResourceRequest> requests = new ArrayList<>();
  		List<WorkingHours> workingHoursData = workRepo.GetAllWorkingHoursOfResouseById(id);
  		for (WorkingHours employeeWH: workingHoursData) {
  			Long resourceId = employeeWH.getUser().getUserId();
  			String projectId = employeeWH.getProject().getProjectId();
  			Integer expectedHour = userProjectRelation.getExpectedWorkingHourOfResource(resourceId, projectId);
  			if (employeeWH.getHours() > expectedHour) {
	  			ResourceRequest request = new ResourceRequest();
	  			request.setKey(key);
	  			key++;
	  			request.setWorkingHourId(employeeWH.getWorkingHourId());
	  			request.setProjectName(employeeWH.getProject().getProjectName());
	  			request.setManagerName(employeeWH.getProject().getManagerUser().getName());
				request.setStartTime(DateTimeFormatter.ofPattern(format).format(employeeWH.getPeriodStart()));
  		    	request.setEndTime(DateTimeFormatter.ofPattern(format).format(employeeWH.getPeriodEnd()));
	  			request.setTimesheetNo(employeeWH.getTimesheetNo());
	  			request.setExtraHours(employeeWH.getHours());
	  			if(employeeWH.getIsActive()) {
	  				request.setStatus("Pending");
	  			} else {
	  				if (employeeWH.getIsApproved()) {
	  					request.setStatus("Approved");
	  				} else {
	  					request.setStatus("Rejected");
	  				}
	  			}

				request.setRequestLogs(logRepo.getAllLogsForId(employeeWH.getWorkingHourId()));
	  			requests.add(request);
  			}
  		}
		return requests; 
	}
	
	@Transactional
	public ResponseEntity<String> updateRequest(OvertimeRequest overtimeReq) {
  		WorkingHours workingHour = workRepo.findById(overtimeReq.getId()).orElse(null);
  		if (workingHour == null) return new ResponseEntity<>("Payload Insufficient", HttpStatus.NO_CONTENT);
  		if (overtimeReq == null || overtimeReq.getResponseText() == null) return new ResponseEntity<>("Data Insufficient", HttpStatus.BAD_REQUEST);
		RequestChangeLog log = new RequestChangeLog();
		log.setTimesheet(workingHour);
		log.setIsApproved(overtimeReq.getIsApproved());
		log.setResponseText(overtimeReq.getResponseText());
		log.setUpdatedOn(LocalDateTime.now()); 
		logRepo.save(log);
  		workingHour.setApprovedOn(LocalDateTime.now());
  		workingHour.setIsActive(false);
  		workingHour.setIsApproved(overtimeReq.getIsApproved());
  		workingHour.setResponseText(overtimeReq.getResponseText());
  		workRepo.save(workingHour);
  		return new ResponseEntity<>("saved", HttpStatus.CREATED); 
	}

	public List<RequestHistory> getAllHistory(String email) {
		Long id = userRepo.findByEmail(email).orElse(null).getUserId();
		Integer key = 1;
  		List<RequestHistory> data = new ArrayList<>();
  		List<WorkingHours> workingHours = workRepo.HistoryOfRequestsForManagerId(id); 
  		for (WorkingHours employeeWH: workingHours) {
  			Long resourceId = employeeWH.getUser().getUserId();
			RequestHistory history = new RequestHistory();
			history.setKey(key);
			key++;
			history.setId(employeeWH.getWorkingHourId());
			history.setUserId(resourceId);
			history.setTimesheetNo(employeeWH.getTimesheetNo());
			history.setName(employeeWH.getUser().getName());
			history.setProjectName(employeeWH.getProject().getProjectName());
			LocalDateTime PeriodStart = employeeWH.getPeriodStart();
			DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
			history.setPeriodStart(DateTimeFormatter.ofPattern(format).format(PeriodStart));
			LocalDateTime PeriodEnd = employeeWH.getPeriodEnd();
			history.setPeriodEnd(DateTimeFormatter.ofPattern(format).format(PeriodEnd));
			history.setHours(employeeWH.getHours());
			if (employeeWH.getIsApproved()) history.setStatus("Approved");
			else history.setStatus("Rejected");
			history.setResponseText(employeeWH.getResponseText());
			Long days = ChronoUnit.DAYS.between(employeeWH.getApprovedOn(), LocalDateTime.now());
			if (days<=7) history.setCanChange(true);
			history.setRequestLogs(logRepo.getAllLogsForId(employeeWH.getWorkingHourId()));
			data.add(history);
  		}
  		return data;
	}
	

}
