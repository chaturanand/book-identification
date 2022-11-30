package com.neesum.javatest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neesum.javatest.model.Book;
import com.neesum.javatest.model.BookIdentification;

/**
 * 
 * @author chatur
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
