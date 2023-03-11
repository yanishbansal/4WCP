package com.Starapp.Starapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Starapp.Starapp.Entities.Project;
import com.Starapp.Starapp.Entities.User;
import com.Starapp.Starapp.dto.response.ResourceDetails;
import com.Starapp.Starapp.repo.UserProjectRelationRepository;
import com.Starapp.Starapp.repo.UserRepository;
import com.Starapp.Starapp.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService{

	@Autowired
	UserRepository userRepo;
  
	@Autowired
	UserProjectRelationRepository relationRepo;

	@Override
	public ResourceDetails getResouceDetail(String email) {
		Long id = userRepo.findByEmail(email).orElse(null).getUserId();
  		ResourceDetails data = new ResourceDetails();
  		User user =  userRepo.findUserWithId(id);
  		List<String> projects = new ArrayList<>();
  		List<String> vertical = new ArrayList<>();
  		List<String> horizontal = new ArrayList<>();
  		List<String> subHorizontal = new ArrayList<>();
  		List<Project> allProjects = relationRepo.findProjectByResouceId(id);
  		for (Project project: allProjects) {
  			projects.add(project.getProjectName());
  			vertical.add(project.getVertical());
  			horizontal.add(project.getHorizonatl());
  			subHorizontal.add(project.getSubHorizontal());
  		}
  		data.setEmail(user.getEmail());
  		data.setName(user.getName());
  		data.setUserId(user.getUserId());
  		data.setProjects(projects);
  		data.setSubHorizontal(subHorizontal);
  		data.setVertical(vertical);
  		data.setHorizontal(horizontal);
  		return data;
	}

}
