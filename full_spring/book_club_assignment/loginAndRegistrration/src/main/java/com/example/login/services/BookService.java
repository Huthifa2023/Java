package com.example.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.login.models.Book;
import com.example.login.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	
	public Book findBook(String title) {
		Optional<Book> book = bookRepository.findByTitle(title);
		if(!book.isPresent()) {
			return null;
		}
		return book.get();
	}
	
	public Book findBookId(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if(!book.isPresent()) {
			return null;
		}
		return book.get();
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
	
	
	public Book createBook(Book book, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<Book> mayBook = bookRepository.findByTitle(book.getTitle());
		if(mayBook.isPresent()) {
			result.rejectValue("Book", "exists", "this book is already added to the website");
			return null;
		}
		bookRepository.save(book);
		return book;
	}
	
}
