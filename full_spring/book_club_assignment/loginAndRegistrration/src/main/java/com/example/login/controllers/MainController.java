package com.example.login.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.login.models.Book;
import com.example.login.models.LoginUser;
import com.example.login.models.User;
import com.example.login.services.BookService;
import com.example.login.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;
	
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
		model.addAttribute("allBooks", bookService.allBooks());
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
	
	@GetMapping("/books/new")
	public String newBook(HttpSession session, Model model, @ModelAttribute("newBook") Book newBook) {
		Long theId = (Long) session.getAttribute("userId");
		if(theId == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "redirect:/";
		}
		Optional<User> user = userService.findUserById(theId);
		model.addAttribute("user", user.get());
		return "newbook.jsp";
	}
	
	@PostMapping("/books/new")
	public String newBook(@Valid @ModelAttribute("newBook") Book newBook, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "newbook.jsp";
		}
		Optional<User> currUser = userService.findUserById((Long) session.getAttribute("userId"));
		newBook.setUser(currUser.get());
		bookService.createBook(newBook, result);
		return"redirect:/dashboard";
	}
	
	
	@GetMapping("/books/{bookId}")
	public String viewBook(@PathVariable("bookId") Long bookId, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			model.addAttribute("newUser", new User());
			model.addAttribute("newLogin", new LoginUser());
			return "redirect:/";
		}
		Book currBook = bookService.findBookId(bookId);
		model.addAttribute("book", currBook);
		Optional<User> currUser = userService.findUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", currUser.get());
		return "viewBook.jsp";
	}
	
	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") Long bookId) {
		bookService.deleteBook(bookId);
		return "redirect:/dashboard";
	}
	
}
