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
@Table(name="subject")
public class Subject extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="lecturer_id")
	@Fetch(FetchMode.JOIN)
	private Lecturer lecturer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id")
	@Fetch(FetchMode.JOIN)
	private Book book;
	
	@JsonBackReference("subject-verification")
	@OneToMany(targetEntity=Verification.class, mappedBy="subject", fetch = FetchType.LAZY)
	private List<Verification> verifications;
	
	@JsonBackReference("subject-lecture")
	@OneToMany(targetEntity=Lecture.class, mappedBy="subject", fetch = FetchType.LAZY)
	private List<Lecture> lectures;
	
	public Subject(){
		
	}
	
	public Subject(String title, Lecturer lecturer, Book book){
		this.title = title;
		this.lecturer = lecturer;
		this.book = book;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Verification> getVerifications() {
		return verifications;
	}

	public void setVerifications(List<Verification> verifications) {
		this.verifications = verifications;
	}

	public List<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}
	
	

}
