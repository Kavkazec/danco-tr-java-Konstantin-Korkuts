package com.danco.training.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="act")
public class Act extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="logon_date")
	private Date logonDate;
	
	@Column(name="logout_date")
	private Date logoutDate;
	
	@Column
	private String resource;
	
	public Act(){
		
	}
	
	
	public Act(User user, Date logonDate, Date logoutDate, String resource){
		this.user = user;
		this.logonDate = logonDate;
		this.logoutDate = logoutDate;
		this.resource = resource;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getLogonDate() {
		return logonDate;
	}

	public void setLogonDate(Date logonDate) {
		this.logonDate = logonDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
}
