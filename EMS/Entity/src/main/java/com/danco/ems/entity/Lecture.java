package com.danco.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="lecture")
public class Lecture extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String type;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	@OneToMany(targetEntity=Schedule.class, mappedBy="lecture", fetch = FetchType.LAZY)
	private List<Schedule> schedules;
	
	public Lecture(){
		
	}
	
	public Lecture(String type, Subject subject){
		this.type = type;
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	

}
