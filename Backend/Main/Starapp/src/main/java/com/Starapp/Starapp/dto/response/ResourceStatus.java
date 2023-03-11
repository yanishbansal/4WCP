package com.Starapp.Starapp.dto.response;

import lombok.Data;

@Data
public class ResourceStatus {
	private Integer resourceApproved;
	private Integer resourceRejected;
	private Integer managerApproved;
	private Integer managerRejected;
}
