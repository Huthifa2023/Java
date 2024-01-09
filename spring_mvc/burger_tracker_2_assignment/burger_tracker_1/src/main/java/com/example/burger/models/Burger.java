package com.example.burger.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "burger")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min = 5, max = 200, message="must be at least 5 characters")
	private String burgerName;
	@NotNull
	@Size(min = 5, max = 200, message="must be at least 5 characters")
	private String resturantName;
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
	@NotNull
	@Column(columnDefinition = "TEXT")
	@Size(min = 5, max = 200, message="must be at least 5 characters")
	private String notes;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    //constructors
    public Burger() {
    }
    public Burger(String burgerName, String resturantName, int rating, String notes) {
    	this.burgerName = burgerName;
    	this.resturantName = resturantName;
    	this.rating = rating;
    	this.notes = notes;
    }
    

	//setters and getters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBurgerName() {
		return burgerName;
	}

	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}

	public String getResturantName() {
		return resturantName;
	}

	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
	
    
}