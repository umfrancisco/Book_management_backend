package com.umfrancisco.book_management_project.book.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.umfrancisco.book_management_project.book.model.Book;
import com.umfrancisco.book_management_project.book.repository.BookRepository;

@Service
public class BookService {
	
	private final BookRepository repository;
	
	public BookService(BookRepository repository) {
		this.repository = repository;
	}
	
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
}
