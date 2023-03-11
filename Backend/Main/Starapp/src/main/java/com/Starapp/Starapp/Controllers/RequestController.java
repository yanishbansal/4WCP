package com.Starapp.Starapp.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Starapp.Starapp.dto.request.MailContent;
import com.Starapp.Starapp.dto.request.OvertimeRequest;
import com.Starapp.Starapp.dto.response.ManagerRequest;
import com.Starapp.Starapp.dto.response.RequestHistory;
import com.Starapp.Starapp.dto.response.ResourceRequest;
import com.Starapp.Starapp.serviceImpl.MailServiceImpl;
import com.Starapp.Starapp.serviceImpl.RequestServiceImpl;

@RestController
@RequestMapping("/api/v1/request")
public class RequestController {
	@Autowired
	RequestServiceImpl requestService;
	
	@Autowired
	MailServiceImpl mailService;
	
  	@GetMapping("/manager")
  	public List<ManagerRequest> getAllManagerRequst(Principal principal) {
  		return requestService.getAllResourceRequestForManager(principal.getName());
  	}
  	
  	@GetMapping("/resource")
  	public List<ResourceRequest> getAllRequests(Principal principal) {
		return requestService.getAllResourceRequest(principal.getName());  		
  	}
  	
  	@GetMapping("/history")
  	public List<RequestHistory> getAllManagerRequestHistory(Principal principal) {
  		return requestService.getAllHistory(principal.getName());
  	}
  	
  	@PostMapping("/manager")
  	public ResponseEntity<String> approvRejectRequsts(@RequestBody OvertimeRequest overtimeReq) {
  		return requestService.updateRequest(overtimeReq);
  	} 
  	
  	@PostMapping("/sendmail")
  	public ResponseEntity<String> sendMail(@RequestBody MailContent mailContent){
  		return mailService.sendMail(mailContent);
  	}
	 
}
