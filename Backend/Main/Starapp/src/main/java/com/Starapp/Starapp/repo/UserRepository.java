package com.Starapp.Starapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Starapp.Starapp.Entities.User;

public interface UserRepository extends JpaRepository<User , Integer>{
	
	@Query(value = "SELECT u FROM User u WHERE u.userId=:id")
	User findUserWithId(@Param("id") Long id);
	
	Optional<User> findByEmail(String email);

	@Query("select u.email from User u where u.userId=:id")
	String getEmailById(@Param("id") Long id);
	
	@Query(value = "SELECT u.name FROM User u WHERE u.userId=:id")
	String findNameById(@Param("id") Long id);

}
