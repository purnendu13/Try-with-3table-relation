package com.example.tableRelationDemo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tableRelationDemo.entity.BookEntity;
import com.example.tableRelationDemo.jpa.BookRepo;

@Service
public class BookService {

	 @Autowired
	    private BookRepo bookRepository;

	    // Create operation
	    public BookEntity createBook(BookEntity book) {
	        return bookRepository.save(book);
	    }

	    // Read operation
	    public List<BookEntity> getAllBooks() {
	        return bookRepository.findAll();
	    }

	    public Optional<BookEntity> getBookById(int id) {
	        return bookRepository.findById(id);
	    }

	    // Update operation
	    public BookEntity updateBook(int id, BookEntity updatedBook) {
	        Optional<BookEntity> existingBook = bookRepository.findById(id);
	        if (existingBook.isPresent()) {
	            updatedBook.setBookId(id);
	            return bookRepository.save(updatedBook);
	        } else {
	            return null; // Book not found
	        }
	    }

	    // Delete operation
	    public void deleteBook(int id) {
	        bookRepository.deleteById(id);
	    }
}
