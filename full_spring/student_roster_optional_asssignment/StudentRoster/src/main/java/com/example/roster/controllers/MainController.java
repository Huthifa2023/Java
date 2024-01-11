package com.example.roster.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.roster.models.Dorm;
import com.example.roster.models.Student;
import com.example.roster.services.DormService;
import com.example.roster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	DormService dormService;
	@Autowired
	StudentService studentService;		//what is this?
	
	
	@GetMapping("/dorms")
	public String dorms(Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return "dorms.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String dormsNew(@ModelAttribute("dorm") Dorm dorm) {
		return "newdorm.jsp";
	}
	
	@PostMapping("/dorms/new")
	public String dormsNew(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorm", dorm);
			return"newdorm.jsp";
		}else {
			dormService.createDorm(dorm);
			return "redirect:/dorms";
		}
	}
	
	@GetMapping("/students/new")
	public String studentsNew(@ModelAttribute("student") Student student, Model model) {
		model.addAttribute("dorms", dormService.allDorms());
		return"newstudent.jsp";
	}
	
	
	@PostMapping("/students/new")
	public String studentsNew(@Valid @ModelAttribute("student") Student student, Model model, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("student", student);
			return "newstudent.jsp";
		} else {
			studentService.createStudent(student);
			return "redirect:/dorms";
		}
	}
	
	@GetMapping("dorms/{dormid}")
	public String viewDorm(@PathVariable("dormid") Long id, Model model, @ModelAttribute("student") Student student) {
		model.addAttribute("dorm", dormService.findDorm(id));
		model.addAttribute("allStudents", studentService.allStudents());
		return "viewdorm.jsp";
	}
	
	@PutMapping("dorms/{dormid}")
	public String viewDorm(@ModelAttribute("student") Student student, Model model, 
			@PathVariable("dormid") Long id) {
		System.out.println(dormService.findDorm(id).getId());   //new dorm
		System.out.println(student.getDorm().getId());			//old dorm
		
		Dorm oldDorm = dormService.findDorm(student.getDorm().getId());
		Student studentToRemove = studentService.findStudent((Long)student.getId());
		System.out.println(studentToRemove);
		oldDorm.getStudents().remove(studentToRemove);
//		
//		Dorm newDorm = dormService.findDorm(id);
//		newDorm.getStudents().add(student);
		
		return "redirect:/dorms/"+id;
	}
}

//Dorm theDorm = dormService.findDorm(id);
//List<Student> allSinDorm =  theDorm.getStudents();
//allSinDorm.add(student);
//theDorm.setStudents(allSinDorm);
