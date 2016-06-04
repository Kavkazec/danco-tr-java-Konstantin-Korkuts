package com.danco.ems.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name="schedule")
public class Schedule extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lecture_id")
	private Lecture lecture;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="groupe_id")
	private Groupe groupe;
	
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
	
	

}
