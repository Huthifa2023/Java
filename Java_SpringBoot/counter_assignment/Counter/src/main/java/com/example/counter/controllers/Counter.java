package com.example.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int theCount = (int) session.getAttribute("count");
			theCount ++;
			session.setAttribute("count", theCount);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count() {
		return "count.jsp";
	}
	
	
	@RequestMapping("/counterbytwo")
	public String countByTwo(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 1);
		}
		else {
			int theCount = (int) session.getAttribute("count");
			theCount += 1;
			session.setAttribute("count", theCount);
		}
		return "countbytwo.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int theCount = (int) session.getAttribute("count");
			theCount *= 0;
			session.setAttribute("count", theCount);
		}
		return "count.jsp";
	}
	
}
