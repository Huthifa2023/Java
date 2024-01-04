package com.example.ninjagold.controllers;

import java.util.Random;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;



@Controller
public class NinjaGoldController {
	@GetMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "");
		}
		return "index.jsp";
	}
	
	@PostMapping("/find")
	public String dig(
			@RequestParam("dig") String dig,
			HttpSession session
			) {
			Random rand = new Random();
			int valueToBeAdded = 0;
			String messageToBeAdded = "";
			switch(dig) {
			  case "farm": 			//10-20 gold
				  int n = rand.nextInt(11) + 10;
				  valueToBeAdded += n;
				  messageToBeAdded += "you enterd the farm earned "+ n +"golds";
			    break;
			  case "cave":			//5-10
				  int j = rand.nextInt(6) + 5;
				  valueToBeAdded += j;
				  messageToBeAdded += "you enterd the cave earned "+ j +"golds";
			    break;
			  case "house":			//2-5
				  int s = rand.nextInt(3) + 3;
				  valueToBeAdded += s;
				  messageToBeAdded += "you enterd the house earned "+ s +"golds";
				break;
			  case "quest":			//0-50 lose possibility
				  int u = rand.nextInt(50);
				  int operation = rand.nextInt(2);
				  valueToBeAdded = (operation == 0) ? valueToBeAdded + u : valueToBeAdded - u;
				break;
			}
			int oldValue = (int) session.getAttribute("gold");
			session.setAttribute("gold", oldValue+valueToBeAdded);
			String oldMessages = (String) session.getAttribute("activities");
			session.setAttribute("activities", oldMessages + messageToBeAdded);
		return "redirect:/";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("activities", null);
		return "redirect:/";
	}
}
