package com.Starapp.Starapp.dto.request;

import lombok.Data;

@Data
public class MailContent {
	  Long id;
      Long managerId;
      Long userId;
      private String responseText;
	  private Boolean isApproved ; 
	
	 
}
