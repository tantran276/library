package com.example.tttn.service.interfaces;

import java.util.List;

import com.example.tttn.entity.Book;
import com.example.tttn.payload.BookDto;

public interface BookService {
	List<BookDto> getAll();
	BookDto findByTitle(String title);
	BookDto findById(long id);
	void saveBook(Book book);
	void deleteById(long id);
	boolean existsByIsbn(String isbn);
	List<Book> findBookByIsbn(String isbn);
	byte[] getImage(long id);
}
