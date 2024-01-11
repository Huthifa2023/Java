package com.example.roster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roster.models.Student;
import com.example.roster.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> allStudents(){
		return studentRepository.findAll();
	}
	
	public Student findStudent(Long id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);
		if(optionalStudent.isPresent()) {
			return optionalStudent.get();
			} else {
				return null;
			}
	}
	
	public void createStudent(Student s) {
		studentRepository.save(s);
	}
	
	public void updateStudent(Student s) {
		studentRepository.save(s);
	}
	
	
}
