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

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="lecturer")
public class Lecturer extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String education;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
	private User user;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Pulpit pulpit;
	
	@OneToMany(targetEntity=Subject.class, mappedBy="lecturer", fetch = FetchType.LAZY)
	private List<Subject> subjects;
	
	
	
	public Lecturer(){
		
	}
	
	public Lecturer(String education, User user, Pulpit pulpit){
		this.education = education;
		this.user = user;
		this.pulpit = pulpit;
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
	
	

}
