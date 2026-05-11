package com.umfrancisco.book_management_project.book.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.book_management_project.book.model.Book;
import com.umfrancisco.book_management_project.book.service.BookService;

@RestController
@RequestMapping("/api/books")
@CrossOrigin
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(service.getAllBooks());
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable int bookId) {
		return ResponseEntity.ok(service.getBookById(bookId));
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return ResponseEntity.ok(service.addBook(book));
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		service.deleteBookById(bookId);
	}
}
