package com.danco.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="groupe")
public class Groupe extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pulpit_id")
	@Fetch(FetchMode.JOIN)
	private Pulpit pulpit;
	
	@JsonIgnore
	@OneToMany(targetEntity=Student.class, mappedBy="groupe", fetch = FetchType.LAZY)
	private List<Student> students;
	
	@JsonIgnore
	@OneToMany(targetEntity=Schedule.class, mappedBy="groupe", fetch = FetchType.LAZY)
	private List<Schedule> schedules;
	
	public Groupe(){
		
	}
	
	public Groupe(String title, Pulpit pulpit){
		this.title = title;
		this.pulpit = pulpit;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Pulpit getPulpit() {
		return pulpit;
	}

	public void setPulpit(Pulpit pulpit) {
		this.pulpit = pulpit;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	

}
