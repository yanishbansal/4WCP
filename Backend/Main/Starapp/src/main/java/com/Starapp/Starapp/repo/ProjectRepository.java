package com.Starapp.Starapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Starapp.Starapp.Entities.Project;

public interface ProjectRepository extends JpaRepository<Project , Integer> {
	
	@Query("select p from Project p where p.managerUser.userId=:id")
	List<Project> allProjectWhereManagerIs(@Param("id") Long id);

}
