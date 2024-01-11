package com.example.roster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.roster.models.Dorm;
import com.example.roster.models.Student;
import com.example.roster.repositories.DormRepository;
import com.example.roster.repositories.StudentRepository;

@Service
public class DormService {
	@Autowired
	DormRepository dormRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	StudentService studentService;
	
	public List<Dorm> allDorms(){
		return dormRepository.findAll();
	}
	
	public Dorm findDorm(Long id) {
		Optional<Dorm> OptionalDorm = dormRepository.findById(id);
		if(OptionalDorm.isPresent()) {
			return OptionalDorm.get();
		} else {
			return null;
		}
	}
	
	public void createDorm(Dorm d) {
		dormRepository.save(d);
	}

	
	
}
