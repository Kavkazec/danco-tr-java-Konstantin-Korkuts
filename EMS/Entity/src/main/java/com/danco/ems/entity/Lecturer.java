package com.danco.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="lecturer")
public class Lecturer extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String education;
	
	@JsonManagedReference("user-lecturer")
	@OneToOne(cascade = CascadeType.MERGE )
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pulpit_id")
	@Fetch(FetchMode.JOIN)
	private Pulpit pulpit;
	
	@Column
	private String status;
	
	@JsonBackReference("lecturer-subject")
	@OneToMany(targetEntity=Subject.class, mappedBy="lecturer", fetch = FetchType.LAZY)
	private List<Subject> subjects;
	
	@JsonBackReference("lecturer-schedule")
	@OneToMany(targetEntity=Schedule.class, mappedBy="lecturer", fetch = FetchType.LAZY)
	private List<Schedule> schedules;
	
	
	
	public Lecturer(){
		
	}
	
	public Lecturer(String education, User user, Pulpit pulpit, String status){
		this.education = education;
		this.user = user;
		this.pulpit = pulpit;
		this.status = status;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pulpit getPulpit() {
		return pulpit;
	}

	public void setPulpit(Pulpit pulpit) {
		this.pulpit = pulpit;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
