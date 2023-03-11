package com.Starapp.Starapp.service;

import com.Starapp.Starapp.dto.response.ManagerRequest;
import com.Starapp.Starapp.dto.response.ResourceRequest;
import com.Starapp.Starapp.dto.response.RequestHistory;

import java.util.List;

public interface RequestService {
	List<ManagerRequest> getAllResourceRequestForManager(String email);
	List<ResourceRequest> getAllResourceRequest(String email);
	List<RequestHistory> getAllHistory(String name);
}
