package com.example.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.test.models.LoginUser;
import com.example.test.models.User;
import com.example.test.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class HomeController {
 
	@Autowired
	private UserService userService;
 
 @GetMapping("/home")
 public String home(HttpSession session) {
	 if(session.getAttribute("userId") != null) {
		 return "home.jsp";
	 }
	return "redirect:/";
 }
 
 @GetMapping("/")
 public String index(Model model) {
 
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "login.jsp";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     User theUser = userService.register(newUser, result);
     if(theUser == null) {
    	 model.addAttribute("newLogin", new LoginUser());
    	 return "login.jsp";
     } else {
    	 session.setAttribute("userId", theUser.getId());
    	 return "redirect:/home";
     }
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     User newRequest = userService.login(newLogin, result);
     if(newRequest == null) {
    	 model.addAttribute("newUser", new User());
    	 return "login.jsp";
     } else {
    	 session.setAttribute("userId", newRequest.getId());
    	 return "redirect:/home";
     } 
 }
 
}

