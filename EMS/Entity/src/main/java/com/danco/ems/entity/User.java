package com.danco.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column
	private String password;
	
	@Column
	private String login;
	
	@Column
	private String role;
	
	@JsonBackReference
	@OneToOne(targetEntity=Lecturer.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Lecturer lecturer;
	
	@JsonBackReference
	@OneToOne(targetEntity=Student.class, mappedBy = "user", fetch = FetchType.LAZY)
	private Student student;

	public User(){
		
	}
	
	public User(String fullName, String password, String login,  String role){
		this.fullName = fullName;
		this.password = password;
		this.role = role;
		this.login = login;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

}
