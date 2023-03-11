package com.Starapp.Starapp.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class UserProjectRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long relationId;
	private Integer expectedHours;
	//foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectId", referencedColumnName = "projectId")
	@JsonManagedReference
	private Project resourceProject;
	
	//foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resourceId", referencedColumnName="userId")
	@JsonManagedReference
	private User projectResource;
}
