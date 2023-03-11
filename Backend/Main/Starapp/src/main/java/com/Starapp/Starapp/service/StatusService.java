package com.Starapp.Starapp.service;

import com.Starapp.Starapp.dto.response.ResourceStatus;

public interface StatusService {
	ResourceStatus getStatus(String email);
}
