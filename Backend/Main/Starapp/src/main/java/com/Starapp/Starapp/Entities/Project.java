package com.Starapp.Starapp.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	private String projectId;
	private String projectName;
	private String customerId;
	private String customerName;
	private String vertical;
	private String horizonatl;
	private String subHorizontal;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "managerId", referencedColumnName="userId")
	@JsonBackReference
	private User managerUser;

	@OneToMany(mappedBy = "project")
	@JsonManagedReference
	private List<WorkingHours> workinghours;

	@OneToMany(mappedBy = "resourceProject")
	@JsonBackReference
	private List<UserProjectRelation> projectResources;

}
