package com.springboot.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springboot.web.dao.BookRepository;
import com.springboot.web.entities.Book;
import com.springboot.web.service.BookService;

@SpringBootTest
class BootrestbookApplicationTests {
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;  
	
	@Test
	void getBook() {
		when(bookRepository.findAll()).thenReturn((Iterable<Book>) Stream.of("new Book(12, \"java complete refernce\" , \"xyz\"));\n"
				+ "	 * list.add(new Book(36, \"Head first to java\" , \"ABC\")); list.add(new\n"
				+ "	 * Book(12963, \" Think in java\", \"LMN\"));"));
		assertEquals(2, bookService.getAllBooks().size());
	}
}
