package com.neesum.javatest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author chatur
 */
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "book_identification")
public class BookIdentification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "book_identification_number")
	private String bookIdentificationNumber;

	@Column(name = "bin")
	@NotBlank(message = "Bin name cannot be blank")
	@Pattern(regexp = "[A-Z]{3}-[0-9]{3}-[0-9]{3}", message = "You must match this Format,: AAA-999-999;\r\n"
			+ "I.e. three uppercase letters, a hyphen, three digits, a hyphen and three digits ")
	private String bin;

	@JsonProperty
	private boolean isInLibrary=true;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "book_id", referencedColumnName = "id", nullable = false)
	private Book book;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookIdentificationNumber() {
		return bookIdentificationNumber;
	}

	public void setBookIdentificationNumber(String bookIdentificationNumber) {
		this.bookIdentificationNumber = bookIdentificationNumber;
	}

	public String getBin() {
		return bin;
	}

	public void setBin(String bin) {
		this.bin = bin;
	}

	public boolean isInLibrary() {
		return isInLibrary;
	}

	public void setInLibrary(boolean isInLibrary) {
		this.isInLibrary = isInLibrary;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookIdentification(long id, String bookIdentificationNumber,
			@NotBlank(message = "Bin name cannot be blank") @Pattern(regexp = "[A-Z]{3}-[0-9]{3}-[0-9]{3}", message = "You must match this Format,: AAA-999-999;\r\nI.e. three uppercase letters, a hyphen, three digits, a hyphen and three digits ") String bin,
			boolean isInLibrary, Book book) {
		this.id = id;
		this.bookIdentificationNumber = bookIdentificationNumber;
		this.bin = bin;
		this.isInLibrary = isInLibrary;
		this.book = book;
	}

	public BookIdentification() {
	}

	@Override
	public String toString() {
		return "BookIdentification [id=" + id + ", bookIdentificationNumber=" + bookIdentificationNumber + ", bin="
				+ bin + ", isInLibrary=" + isInLibrary + ", book=" + book + "]";
	}
	
	

	
	
}
