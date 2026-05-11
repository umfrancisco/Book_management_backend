package com.umfrancisco.book_management_project.book.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.umfrancisco.book_management_project.book.model.Book;
import com.umfrancisco.book_management_project.book.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	private final BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(service.getAllBooks());
	}
}
