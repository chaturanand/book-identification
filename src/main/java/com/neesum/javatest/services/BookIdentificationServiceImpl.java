package com.neesum.javatest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neesum.javatest.model.Book;
import com.neesum.javatest.model.BookIdentification;
import com.neesum.javatest.repository.BookIdentifactionRepository;
import com.neesum.javatest.repository.BookRepository;

/**
 * 
 * @author chatur
 *
 */
@Service
public class BookIdentificationServiceImpl implements BookIdentificationService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookIdentifactionRepository bookIdentifactionRepository;

	@Override
	public BookIdentification createBookIdentification(BookIdentification bookIdentification) {
		
		Book persistBook = bookRepository.save(bookIdentification.getBook());
		bookIdentification.setBook(persistBook);
		return bookIdentifactionRepository.save(bookIdentification);
	}

}
