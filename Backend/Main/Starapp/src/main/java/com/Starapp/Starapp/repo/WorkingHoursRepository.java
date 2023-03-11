package com.Starapp.Starapp.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Starapp.Starapp.Entities.WorkingHours;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours , Integer> {
	@Query("select w from WorkingHours w where w.workingHourId=:id")
	Optional<WorkingHours> findById(@Param("id") Long id);
	
	//
     
	@Query("select w.timesheetNo from WorkingHours w where w.workingHourId=:id")
	String getTimesheetNoById(@Param("id") Long id);
	
	@Query("select w.periodStart from WorkingHours w where w.workingHourId=:id")
	String getByPeriodStartId(@Param("id") Long id);
	
	@Query("select w.periodEnd from WorkingHours w where w.workingHourId=:id")
	String getByPeriodEndId(@Param("id") Long id);
	
	

	//
	@Query("select w from WorkingHours w where w.project.managerUser.userId=:id and w.isActive=true")
	List<WorkingHours> WorkingHoursOfResourcesForManagerId(@Param("id") Long id);

	@Query("select w from WorkingHours w where w.user.userId=:id")
	List<WorkingHours> GetAllWorkingHoursOfResouseById(@Param("id") Long id);

	@Query(value="select count(w) from WorkingHours w where w.user.userId=:id and w.isActive=false and w.isApproved=true")
	Integer getResourceApprovedStatus(Long id);
	
	@Query(value="select count(w) from WorkingHours w where w.user.userId=:id and w.isActive=false and w.isApproved=false")
	Integer getResourceRejectedStatus(Long id);
	
	@Query(value="select count(w) from WorkingHours w where w.project.managerUser.userId=:id and w.isActive=false and w.isApproved=true")
	Integer getResourceApprovedStatusForManager(Long id);

	@Query(value="select count(w) from WorkingHours w where w.project.managerUser.userId=:id and w.isActive=false and w.isApproved=false")
	Integer getResourceRejectedStatusForManager(Long id);


	@Query("select w from WorkingHours w where w.project.managerUser.userId=:id and w.isActive=false")
	List<WorkingHours> HistoryOfRequestsForManagerId(Long id);

}
