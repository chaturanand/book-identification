package com.neesum.javatest.repository;

/**
 * @author chatur
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neesum.javatest.model.BookIdentification;


@Repository
public interface BookIdentifactionRepository extends JpaRepository<BookIdentification, Long> {

}
