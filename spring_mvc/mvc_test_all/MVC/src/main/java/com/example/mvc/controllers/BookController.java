package com.example.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.models.Book;
import com.example.mvc.services.BookService;

import jakarta.validation.Valid;

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
	
	 @GetMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    }
	 
	 @PostMapping("/books")
	 public String create(@Valid @ModelAttribute("book") Book book, BindingResult result)
	 {
	     if(result.hasErrors()) {
	    	 return "new.jsp";
	     } else {
	    	 bookService.createBook(book);
		     return "redirect:/books";
	     }  
	 }
	 
	 @GetMapping("/books/new")
	 public String newBook(@ModelAttribute("book") Book book) {
		 return "new.jsp";
	 }
	 
	 @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "edit.jsp";
	    }
	    
	    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("book", book);
	            return "edit.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
	    
	    @DeleteMapping("/books/{id}/delete")
	    public String destroy(@PathVariable("id") Long id) {
	        bookService.deleteBook(id);
	        return "redirect:/books";
	    }
}
