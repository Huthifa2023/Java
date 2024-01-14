package com.example.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import com.example.login.models.LoginUser;
import com.example.login.models.User;


@Controller
public class MainController {
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
	return "login.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		Long theId = (Long) session.getAttribute("userId");
		if(theId == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "redirect:/";
		}
		Optional<User> user = userService.findUserById(theId);
		model.addAttribute("user", user.get());
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result,
			Model model, HttpSession session) {
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		User user = userService.register(newUser, result);
		if(user == null) {
			model.addAttribute("newLogin", new LoginUser());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		return "redirect:/dashboard";
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
	    	 return "redirect:/dashboard";
	     } 
	 }
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
