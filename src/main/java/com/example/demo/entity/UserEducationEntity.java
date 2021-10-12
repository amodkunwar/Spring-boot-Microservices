package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USER_EDUCATION")
@Entity
public class UserEducationEntity {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "percentage")
	private String percentage;

	@Column(name = "qualification")
	private String qualification;

	public UserEducationEntity() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

}
