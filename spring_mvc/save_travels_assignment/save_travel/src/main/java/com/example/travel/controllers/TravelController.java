package com.example.travel.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.travel.models.Travel;
import com.example.travel.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
	private final TravelService travelService;
	public TravelController(TravelService travelService){
		this.travelService = travelService;
	}
	
	@GetMapping("/")
	public String index(Model model,
			@ModelAttribute("travel") Travel travel) {
		List<Travel> travels = travelService.allTravels();
		model.addAttribute("travels", travels);
		return "index.jsp";
	}
	
	@PostMapping("/addtravel")
	public String addTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
	    	 List<Travel> travels = travelService.allTravels();
	    	 model.addAttribute("travels", travels);
	    	 return "index.jsp";
	     } else {
	    	 travelService.createTravel(travel);
		     return "redirect:/";
	     }  
	}
	
	@GetMapping("/travel/edit/{id}")
	public String editTravel(Model model, @PathVariable("id") Long id) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("travel", travel);
		return "edit.jsp";
	}
	
	@PutMapping("/travel/edit/{id}")
	public String eidtTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	travelService.createTravel(travel);
            return "redirect:/";
        }
	}
	
	
	
	
}
