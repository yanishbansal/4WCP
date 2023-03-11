package com.Starapp.Starapp.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserProjectRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int relationId;
	
	//foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "projectId",referencedColumnName = "projectId")
	Project project;
	
	//foreign key
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resourceId",referencedColumnName="userId")
	User user;

	public int getRelationId() {
		return relationId;
	}

	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserProjectRelation(int relationId, Project project, User user) {
		super();
		this.relationId = relationId;
		this.project = project;
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserProjectRelation [relationId=" + relationId + ", project=" + project + ", user=" + user + "]";
	}
	
}
