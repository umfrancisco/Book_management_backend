package com.umfrancisco.book_management_project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.book_management_project.model.Book;
import com.umfrancisco.book_management_project.service.BookService;

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
	
	@GetMapping("title/{title}")
	public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
		return ResponseEntity.ok(service.getBookByTitle(title));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id) {
		Book book = service.getBookById(id);
		if (book == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book saved = service.addBook(book);
		if (saved == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(saved, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable int id) {
		service.deleteBookById(id);
	}
}
