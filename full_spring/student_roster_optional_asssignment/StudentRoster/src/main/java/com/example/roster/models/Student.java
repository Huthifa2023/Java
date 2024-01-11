package com.example.roster.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=5, max=255)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dorm_id")
	private Dorm dorm;
	
	//empty constructor
	public Student() {}

	
	//setters and getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Dorm getDorm() {
		return dorm;
	}

	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}
	
	
	
	
}
