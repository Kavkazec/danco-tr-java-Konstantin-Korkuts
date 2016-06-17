package com.danco.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pulpit")
public class Pulpit extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@OneToMany(targetEntity=Groupe.class, mappedBy="pulpit", fetch = FetchType.LAZY)
	private List<Groupe> groupes;
	
	@OneToMany(targetEntity=Lecturer.class, mappedBy="pulpit", fetch = FetchType.LAZY)
	private List<Lecturer> lecturers;
	
	public Pulpit(){
		
	}
	
	public Pulpit(String title){
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(List<Groupe> groupes) {
		this.groupes = groupes;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
	
	

}