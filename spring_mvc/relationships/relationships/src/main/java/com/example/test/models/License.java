package com.example.test.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

//...
@Entity
@Table(name="licenses")
public class License {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String number;
	 private Date expirationDate;
	 private String state;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 
	 @OneToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="person_id")
	 private Person person;
	 
	 
	 public License() {
	 }
	 public License(String number, Date expirationDate, String state) {
		 this.number = number;
		 this.expirationDate = expirationDate;
		 this.state = state;
	 }
	 
	 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
 
 
}


