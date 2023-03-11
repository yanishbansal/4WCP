package com.Starapp.Starapp.Entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int adminId;
	String name;
	String email;
	String assword;
	LocalDateTime lastActive;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAssword() {
		return assword;
	}
	public void setAssword(String assword) {
		this.assword = assword;
	}
	public LocalDateTime getLastActive() {
		return lastActive;
	}
	public void setLastActive(LocalDateTime lastActive) {
		this.lastActive = lastActive;
	}
	public Admin(int adminId, String name, String email, String assword, LocalDateTime lastActive) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.assword = assword;
		this.lastActive = lastActive;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", email=" + email + ", assword=" + assword
				+ ", lastActive=" + lastActive + "]";
	}
	
	
}
