package com.umfrancisco.book_management_project.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.umfrancisco.book_management_project.book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	Book findByTitle(String title);
	boolean existsByTitle(String title);
	boolean existsByAuthor(String author);
}
