package com.example.tableRelationDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.tableRelationDemo.Service.BookService;
import com.example.tableRelationDemo.entity.BookEntity;

@RestController
@RequestMapping("/books")
public class BookController {
	   @Autowired
	    private BookService bookService;

	    @PostMapping
	    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
	        BookEntity createdBook = bookService.createBook(book);
	        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<BookEntity>> getAllBooks() {
	        List<BookEntity> books = bookService.getAllBooks();
	        return new ResponseEntity<>(books, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<BookEntity> getBookById(@PathVariable("id") int id) {
	        return bookService.getBookById(id)
	                .map(book -> new ResponseEntity<>(book, HttpStatus.OK))
	                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<BookEntity> updateBook(@PathVariable("id") int id, @RequestBody BookEntity updatedBook) {
	        BookEntity book = bookService.updateBook(id, updatedBook);
	        if (book != null) {
	            return new ResponseEntity<>(book, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
	        bookService.deleteBook(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
