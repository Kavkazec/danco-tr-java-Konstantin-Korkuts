package com.danco.ems.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private boolean steward;
	
	@Column
	private String interests;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="groupe_id")
	private Groupe groupe;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
	private User user;
	
	@Column
	private StudentStatus status;
	
	@Column(name="study_start")
	private Date studyStart;
	
	@Column(name="count_year")
	private int countYear;
	
	@OneToMany(targetEntity=Verification.class, mappedBy="student", fetch = FetchType.LAZY)
	private List<Verification> verifications;
	
	
	public Student(){
		
	}
	
	public Student(boolean steward, String interests, Groupe groupe, User user, StudentStatus status, Date studyStart, int countYear){
		this.steward = steward;
		this.interests = interests;
		this.groupe = groupe;
		this.user = user;
		this.status = status;
		this.studyStart = studyStart;
		this.countYear = countYear;
	}

	public boolean isSteward() {
		return steward;
	}

	public void setSteward(boolean steward) {
		this.steward = steward;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public User getUser() {
		return user;
	}

	public void setUesr(User user) {
		this.user = user;
	}

	public StudentStatus getStatus() {
		return status;
	}

	public void setStatus(StudentStatus status) {
		this.status = status;
	}

	public Date getStudyStart() {
		return studyStart;
	}

	public void setStudyStart(Date studyStart) {
		this.studyStart = studyStart;
	}

	public int getCountYear() {
		return countYear;
	}

	public void setCountYear(int countYear) {
		this.countYear = countYear;
	}

	public List<Verification> getVerifications() {
		return verifications;
	}

	public void setVerifications(List<Verification> verifications) {
		this.verifications = verifications;
	}


}
