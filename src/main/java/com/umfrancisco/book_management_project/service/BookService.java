package com.umfrancisco.book_management_project.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.umfrancisco.book_management_project.model.Book;
import com.umfrancisco.book_management_project.repository.BookRepository;

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
	
	public Book getBookByTitle(String title) {
		return repository.findByTitle(title);
	}
	
	public Book getBookById(int bookId) {
		Book book = null;
		try {
			book = repository.findById(bookId).get();			
		} catch (Exception e) {
			log.error("BOOK ID NOT FOUND "+bookId);
		}
		return book;
	}
	
	public Book addBook(Book book) {
		List<Book> allBooks = getAllBooks();
		for (var existingBook : allBooks) {
			if (book.getTitle().equalsIgnoreCase(existingBook.getTitle())) {
				log.error("EXISTING BOOK: "+book);
				return null;
			}
		}
		Book saved = repository.save(book);
		return saved;
	}
	
	public void deleteBookById(int bookId) {
		Book book = repository.findById(bookId).get();
		if (book != null) {
			repository.deleteById(book.getBookId());
			log.info("DELETED BOOK: "+book);
		}
	}
}
