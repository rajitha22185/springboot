package com.ojas.service;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.entity.BookEntity;
import com.ojas.model.Book;
import com.ojas.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public boolean saveBook(Book book) {

		BookEntity bookEntity = new BookEntity();

		BeanUtils.copyProperties(book, bookEntity);

		boolean flag = false;
		if (book != null) {
			BookEntity b = bookRepo.save(bookEntity);
			if (b != null) {
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public List<Book> findAllBooks() {

		List<BookEntity> books = bookRepo.findAll();
		List<Book> bookList = new ArrayList<>();

		for (BookEntity e : books) {
			Book b = new Book();

			BeanUtils.copyProperties(e, b);

			bookList.add(b);
		}

		return bookList;
	}

	@Override
	public Book findBookById(int id) {

		Book b = new Book();
		Optional<BookEntity> op = bookRepo.findById(id);
		BookEntity book = op.get();

		BeanUtils.copyProperties(book, b);

		return b;
	}

	@Override
	public boolean updateBook(Book book) {

		BookEntity bookEntity = new BookEntity();
		BeanUtils.copyProperties(book, bookEntity);

		boolean flag = false;
		Optional<BookEntity> op = bookRepo.findById(bookEntity.getBid());
		BookEntity e = op.get();
		if (e != null) {
              System.out.println();
			bookRepo.save(bookEntity);
			flag = true;
		}

		return flag;
	}

	@Override
	public boolean deleteById(int id) {
		boolean flag = false;

		Optional<BookEntity> op = bookRepo.findById(id);
		BookEntity b = op.get();
		if (b != null) {
			bookRepo.delete(b);
			flag = true;
		}
		return flag;
	}

}
