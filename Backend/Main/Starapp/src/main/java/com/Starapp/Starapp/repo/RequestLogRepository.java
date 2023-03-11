package com.Starapp.Starapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Starapp.Starapp.Entities.RequestChangeLog;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestChangeLog , Integer> {

	@Query("select log from RequestChangeLog log where log.timesheet.workingHourId=:id order by log.updatedOn desc")
	List<RequestChangeLog> getAllLogsForId(@Param("id") Long id);

}
