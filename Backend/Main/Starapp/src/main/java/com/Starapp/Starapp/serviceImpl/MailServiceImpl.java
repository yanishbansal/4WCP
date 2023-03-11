package com.Starapp.Starapp.serviceImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Starapp.Starapp.Entities.WorkingHours;
import com.Starapp.Starapp.dto.request.MailContent;
import com.Starapp.Starapp.repo.UserRepository;
import com.Starapp.Starapp.repo.WorkingHoursRepository;
import com.Starapp.Starapp.service.MailService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	WorkingHoursRepository workingRepo;
	
	
	
	@Autowired private JavaMailSender javaMailSender;
	@Value("${spring.mail.username}") private String sender;
	 
	 
	
	public ResponseEntity<String> sendMail(MailContent mailContent) {

		String managerEmail = userRepo.getEmailById(mailContent.getManagerId());
		String empMail = userRepo.getEmailById(mailContent.getUserId());
		String message = mailContent.getResponseText();
		String EmployeeName = userRepo.findNameById(mailContent.getUserId());
		String ManagerName = userRepo.findNameById(mailContent.getManagerId());
		WorkingHours wh = workingRepo.findById(mailContent.getId()).orElse(null);
		String ResponseType ;
		if(mailContent.getIsApproved())
			ResponseType = "has been Approved by ";
		else 
			ResponseType = "has been Rejected by ";
		
		LocalDateTime PeriodStart =	wh.getPeriodStart();
		DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String periodStart= DateTimeFormatter.ofPattern("dd-MMM-yyyy")
				  .format(PeriodStart);
		LocalDateTime PeriodEnd = wh.getPeriodEnd();
		DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String periodEnd= DateTimeFormatter.ofPattern("dd-MMM-yyyy")
				  .format(PeriodEnd);
		
		message = EmployeeName+"'s"+" request for approval of working hour of "+wh.getHours()+"h\n\tTimesheet: " +wh.getTimesheetNo()+"\n\tTime period: " +
				periodStart+" - " +periodEnd+"\n\tProject: "+wh.getProject().getProjectName() 
				+"\n"+ResponseType+ManagerName+"\nResponse Text: "+message+"\n\nThis is a system generated mail, Do not reply";
		
		try {
 
        	SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo( managerEmail, empMail );
            
            mailMessage.setText(message);
            mailMessage.setSubject("Timesheet Requests");

            
            // Sending the mail
            javaMailSender.send(mailMessage);
        }
 
        // Catch block to handle the exceptions
        catch (Exception e) {
        	return new ResponseEntity<>("Error", HttpStatus.EXPECTATION_FAILED); 
        }
  		return new ResponseEntity<>("sent mail succesfully", HttpStatus.ACCEPTED); 
		
	}
}
