package com.danco.ems.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="book")
public class Book extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column(name="pages")
	private int countPage;
	
	@JsonIgnore
	@OneToMany(targetEntity=Subject.class, mappedBy="book", fetch = FetchType.LAZY)
	private List<Subject> subject;
	
	public Book(){
		
	}
	
	public Book(String title, String author, int countPage){
		this.title = title;
		this.author = author;
		this.countPage = countPage;
	}
	
	public Book(int id, String title, String author, int countPage){
		super(id);
		this.title = title;
		this.author = author;
		this.countPage = countPage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCountPage() {
		return countPage;
	}

	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
	

}
