package com.springboot.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.web.dao.BookRepository;
import com.springboot.web.entities.Book;

@Component
public class BookService {
	
	@Autowired
	private  BookRepository bookRepository;
//	private static List <Book> list = new ArrayList<>();
	/*
	 * static { list.add(new Book(12, "java complete refernce" , "xyz"));
	 * list.add(new Book(36, "Head first to java" , "ABC")); list.add(new
	 * Book(12963, " Think in java", "LMN"));
	 * 
	 * }
	 */
//	get all book
	public List<Book> getAllBooks(){
		List<Book> list =(List<Book>)this.bookRepository.findAll();
		return list;
	}
//	get single book by id
	
	public Book getBookId(int id) {	
		Book book = null;
		try {
//		list.stream().filter(e -> e.getId()==id).findFirst().get();
			book=this.bookRepository.findById(id);
			
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		return book;
	}
//	adding the book
	public Book addBook(Book b) {
		Book result =bookRepository.save(b);
		return result;
	}
//delete book	
	public void deleteBook(int bid) {
		/*
		 * list=list.stream().filter(book ->{ if(book.getId()!=bid) { return true; }
		 * else { return false; }
		 * 
		 * }).collect(Collectors.toList());
		 */
		bookRepository.deleteById(bid);
	}
//	update the  book 
	public void updateBook(Book book , int BookId) {
		/*
		 * list = list.stream().map( b ->{ if(b.getId() == BookId)
		 * 
		 * { b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); }
		 * 
		 * return b;
		 * 
		 * }).collect(Collectors.toList());
		 */
		book.setId(BookId);
		bookRepository.save(book);
		
	}
}
