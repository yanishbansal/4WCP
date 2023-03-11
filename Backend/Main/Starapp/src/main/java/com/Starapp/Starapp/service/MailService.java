package com.Starapp.Starapp.service;

import org.springframework.http.ResponseEntity;

import com.Starapp.Starapp.dto.request.MailContent;

public interface MailService {
	ResponseEntity<String> sendMail(MailContent mailContent);
}
