package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.entity.Book;


@Service
public class BookService {
	
	
	private  static List<Book> list = new ArrayList<>();
	
	static {
		list.add(new Book(12,"Python", "wdf"));
		list.add(new Book(11,"Ruby", "tyui"));
		list.add(new Book(13,"Flutter", "sdfgh"));
		list.add(new Book(14,"React", "cvd"));
		list.add(new Book(16,"Swift", "wed"));
	}
	
	public List<Book> getAllBooks(){
		return list;
	}
	
	public Book getById(int id) {
		
		Book b= null;
//		list.forEach(bo -> {
//			if(id==bo.getId()) {
//				b=bo;
//			}
//		});

		b = list.stream().filter(e->e.getId()==id).findFirst().get();
		return b;
	}
	
	public void addBook(Book b) {
		list.add(b);
	}
	
	public void deleteBook(int bId) {
		list = list.stream().filter(e->e.getId()!=bId).collect(Collectors.toList());
	}
	
	public void updateBook(Book book, int bookId) {
		
//		Book b=null;
//		b = list.stream().filter(e->e.getId()==bookId).findFirst().get();
//		
//		if(b!=null){
//			b.setTitle(book.getTitle());
//			b.setAuthor(book.getAuthor());
//		}
		
		list = list.stream().map( b ->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
