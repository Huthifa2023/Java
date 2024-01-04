package com.example.omi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class Omikuji {
	@RequestMapping("/omikuji")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/sendomi")
	public String getData(
			@RequestParam(value ="number") String number,
			@RequestParam(value ="city") String city,
			@RequestParam(value ="person") String person,
			@RequestParam(value ="hobby") String hobby,
			@RequestParam(value ="livingthing") String livingthing,
			@RequestParam(value ="nice") String nice,
			HttpSession session
			) {
			session.setAttribute("number", number);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("livingthing", livingthing);
			session.setAttribute("nice", nice);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String show() {
		return "results.jsp";
	}
	
}
