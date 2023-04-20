package com.ojas.service;

import java.util.List;

import com.ojas.entity.BookEntity;
import com.ojas.model.Book;

public interface BookService {
              
	public boolean saveBook(Book book);
	public List<Book> findAllBooks();
	public Book findBookById(int id);
	public boolean updateBook(Book book);
	public boolean deleteById(int id);
	
	
}
