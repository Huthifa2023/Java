package com.example.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

@Controller
public class BookController {
	private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
	
	@RequestMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book theBook = bookService.findBook(id);
		model.addAttribute("id", theBook.getId());
		model.addAttribute("title", theBook.getTitle());
		model.addAttribute("description", theBook.getDescription());
		model.addAttribute("language", theBook.getLanguage());
		model.addAttribute("numPages", theBook.getNumberOfPages());
		return "show.jsp";
	}
}
