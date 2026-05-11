package com.umfrancisco.book_management_project.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    
    public Book() {
    }
    
	public Book(int bookId, String title, String author, String publisher, int publicationYear) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
	}
	
	public int getBookId() {
		return bookId;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
}
