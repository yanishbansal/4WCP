package com.Starapp.Starapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query .Param;

import com.Starapp.Starapp.Entities.Project;
import com.Starapp.Starapp.Entities.UserProjectRelation;

public interface UserProjectRelationRepository extends JpaRepository<UserProjectRelation , Integer>{

	@Query(value="select upr.resourceProject from UserProjectRelation upr where upr.projectResource.userId=:id")
	List<Project> findProjectByResouceId(@Param("id") Long id);
	
	@Query(value="select upr.expectedHours from UserProjectRelation upr where "
			+ "upr.projectResource.userId=:userId and upr.resourceProject.projectId=:projectId")
	int getExpectedWorkingHourOfResource(@Param("userId") Long userId, @Param("projectId") String projectId);

}
