package com.umfrancisco.book_management_project.model;

import java.util.Random;
import org.springframework.stereotype.Component;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "books")
public class Book {
	
	@Id
	private int bookId;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private double price;
    private int stock;
    
    public Book() {
    	
    }
    
	public Book(String title, String author, String publisher, int publicationYear, double price,
			int stock) {
		this.bookId = new Random().nextInt(1000);
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.price = price;
		this.stock = stock;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", publisher=" + publisher
				+ ", publicationYear=" + publicationYear + ", price=" + price + ", stock=" + stock + "]";
	}
}
