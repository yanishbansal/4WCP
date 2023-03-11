package com.Starapp.Starapp.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Starapp.Starapp.dto.response.ResourceStatus;
import com.Starapp.Starapp.repo.UserRepository;
import com.Starapp.Starapp.repo.WorkingHoursRepository;
import com.Starapp.Starapp.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	UserRepository userRepo;
	@Autowired
	WorkingHoursRepository workingHourRepo;
	
	@Override
	public ResourceStatus getStatus(String email) {
		ResourceStatus status = new ResourceStatus();
		Long id = userRepo.findByEmail(email).orElse(null).getUserId();
		status.setResourceApproved(workingHourRepo.getResourceApprovedStatus(id));
		status.setResourceRejected(workingHourRepo.getResourceRejectedStatus(id));
		status.setManagerApproved(workingHourRepo.getResourceApprovedStatusForManager(id));
		status.setManagerRejected(workingHourRepo.getResourceRejectedStatusForManager(id));
		return status;
	}

}
