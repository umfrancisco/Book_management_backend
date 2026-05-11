package com.umfrancisco.book_management_project.book.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.umfrancisco.book_management_project.book.model.Book;
import com.umfrancisco.book_management_project.book.repository.BookRepository;

@Service
public class BookService {
	
	private static final Logger log = LoggerFactory.getLogger(BookService.class);
	private final BookRepository repository;
	
	public BookService(BookRepository repository) {
		this.repository = repository;
	}
	
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
	
	public Book getBookById(int bookId) {
		return repository.findById(bookId).get();
	}
	
	public Book addBook(Book book) {
		boolean existingBookId = repository.existsById(book.getBookId());
		boolean existingBook = repository.existsByTitle(book.getTitle());
		boolean existingAuthor = repository.existsByAuthor(book.getAuthor());
		if ((existingBook && existingAuthor) || existingBookId) {
			log.error("This book already exists: "+book);
		}
		Book saved = repository.save(book);
		return saved;
	}
	
	public void deleteBookById(int bookId) {
		Book book = repository.findById(bookId).get();
		if (book != null) {
			repository.deleteById(book.getBookId());
			log.info("Deleted "+book);
		}
	}
}
