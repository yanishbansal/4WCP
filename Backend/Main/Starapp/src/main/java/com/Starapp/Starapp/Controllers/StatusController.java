package com.Starapp.Starapp.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Starapp.Starapp.dto.response.ResourceStatus;
import com.Starapp.Starapp.serviceImpl.StatusServiceImpl;

@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
	@Autowired
	StatusServiceImpl statusService;
	
	@GetMapping("/getstatus")
	ResourceStatus getStatusForResours(Principal principal) {
		return statusService.getStatus(principal.getName());
	}
}
