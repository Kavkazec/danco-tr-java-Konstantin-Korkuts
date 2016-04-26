package com.danco.point.entity;

import java.util.Date;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private Date bDate;
	private String gender;
	private String tittle;
	
	public Employee(int id, String firstName, String lastName, Date bDate, String gender, String tittle){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bDate = bDate;
		this.gender = gender;
		this.tittle = tittle;
	}
	
	public Employee(String firstName, String lastName, Date bDate, String gender, String tittle){
		this.firstName = firstName;
		this.lastName = lastName;
		this.bDate = bDate;
		this.gender = gender;
		this.tittle = tittle;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getbDate() {
		return bDate;
	}
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	
}
