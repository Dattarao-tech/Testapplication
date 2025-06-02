package com.springboot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.entities.Book;
import com.springboot.web.service.BookService;

@RestController
public class BookController {
	
//	get all books handler	
	@Autowired
	private BookService bookService;
//	get single book handler
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookService.getAllBooks();
	}
//	new book handler
	@PostMapping("/books")
	public Book addBook( @RequestBody Book book) {	
		Book b=this.bookService.addBook(book);
		System.out.println(book);
		return b;
	}
//	delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {	
		this.bookService.deleteBook(bookId);
	}
//	update book handler
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book ,@PathVariable("bookId") int bookId) {
		
		this.bookService.updateBook(book, bookId);
		return book;
	}
}

