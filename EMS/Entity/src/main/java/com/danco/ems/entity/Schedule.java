package com.danco.ems.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="schedule")
public class Schedule extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lecture_id")
	@Fetch(FetchMode.JOIN)
	private Lecture lecture;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="groupe_id")
	@Fetch(FetchMode.JOIN)
	private Groupe groupe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lecturer_id")
	@Fetch(FetchMode.JOIN)
	private Lecturer lecturer;
	
	@Column
	private Date date;
	
	public Schedule(){
		
	}
	
	public Schedule(Lecture lecture, Groupe groupe, Date date){
		this.lecture = lecture;
		this.groupe = groupe;
		this.date = date;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	

}
