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

import com.neesum.javatest.model.BookIdentification;
import com.neesum.javatest.repository.BookIdentifactionRepository;
import com.neesum.javatest.services.BookIdentificationService;

/**
 * 
 * @author chatur
 *
 */
@RestController
@RequestMapping("/api/v1")
public class BookIdentificationController {
	
	@Autowired
	private BookIdentifactionRepository bookIdentifactionRepository;
	
	@Autowired
	private BookIdentificationService bookIdentificationService;
	
	
	

	@GetMapping("/bookidentifications")
	public List<BookIdentification> getAllBooks() {
	    return bookIdentifactionRepository.findAll();
	}
	
	@PostMapping("/bookidentifications")
	public ResponseEntity<BookIdentification> saveBook(@RequestBody @Valid BookIdentification bookIdentification){

		try {
		BookIdentification _bookIdentification = bookIdentificationService.createBookIdentification(bookIdentification);
		return new ResponseEntity<>(_bookIdentification, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
