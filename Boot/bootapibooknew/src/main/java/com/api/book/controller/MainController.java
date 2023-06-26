package com.api.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entity.Book;
import com.api.book.services.BookService;


@RestController
public class MainController {

	
	@Autowired
	private BookService bookService;
	
	
	@GetMapping(value="/home")
	public ResponseEntity<List<Book>> getBook() {
//		Book book = new Book();
//		book.setAuthor("tarun");
//		book.setId(1234);
//		book.setTitle("Java");
		
		List<Book> books;
		books=this.bookService.getAllBooks();
		if(books.size()<1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		
		return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/home/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") Integer id) {
		
		Book book=null;
		try {
			book=this.bookService.getById(id);
		}
		catch (Exception e) {
			System.out.println("hhii yy");
			System.out.println(e.toString());
			Map<String, String>bodyMap=new HashMap<>();
			bodyMap.put("message", "Book doesn't exists.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bodyMap);
			
		}
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/home")
	public Book addBook(@RequestBody Book book) {
		this.bookService.addBook(book);
		return book;
	}
	
	@DeleteMapping("/home/{id}")
	public Object deleteBook(@PathVariable("id") int bookId) {
		this.bookService.deleteBook(bookId);
		return getBook();
	}
	     
	@PutMapping("/home/{id}")
	public String updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		System.out.println(id);
		this.bookService.updateBook(book,id);
		return "Book with Id "+book.getId()+" is updated.";
	}
}
