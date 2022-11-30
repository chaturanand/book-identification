package com.neesum.javatest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neesum.javatest.model.Book;
import com.neesum.javatest.repository.BookRepository;

@RestController
@RequestMapping("/api/v1")

/**
 * 
 * @author chatur
 *
 */
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	

	@GetMapping("/books")
	public List<Book> getAllBooks() {
	    return bookRepository.findAll();
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> saveBook(@RequestBody @Valid Book book){
		try {
			Book _book = 
			bookRepository.save(book);
			return new ResponseEntity<>(_book,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
