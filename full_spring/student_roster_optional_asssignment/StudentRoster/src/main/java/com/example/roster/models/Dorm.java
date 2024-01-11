package com.example.roster.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity						//do they come from MySQL dependency?
@Table(name="dorms")
public class Dorm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=5, max=255)
	private String name;
	
	@OneToMany(mappedBy="dorm", fetch = FetchType.LAZY)
	private List<Student> students; 
	
	
	//beans empty constructor
	public Dorm() {	
	}
	
//	public Dorm(Long id, String name, List<Student> students) {
//		this.id = id;
//		this.name = name;
//		this.students = students;
//	}


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


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
}
