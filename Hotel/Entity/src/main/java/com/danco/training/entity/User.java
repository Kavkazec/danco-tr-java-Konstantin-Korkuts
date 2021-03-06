package com.danco.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4002725813052615269L;

	@Column
	private String login;
	
	@Column
	private String password;
	
	public User(String login, String password){
		this.login = login;
		this.password = password;
	}
	
	public User(){
		
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
