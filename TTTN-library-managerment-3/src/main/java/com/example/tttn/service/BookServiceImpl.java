package com.example.tttn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tttn.entity.Book;
import com.example.tttn.mapper.BookDtoMapper;
import com.example.tttn.payload.BookDto;
import com.example.tttn.repository.BookRepository;
import com.example.tttn.service.interfaces.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<BookDto> getAll() {
		List<BookDto> bookDtos = new ArrayList<>();
		bookRepository.findAll().forEach(book -> {
			bookDtos.add(BookDtoMapper.toBookDto(book));
		});
		return bookDtos;
	}

	@Override
	public BookDto findByTitle(String title) {
		return BookDtoMapper.toBookDto(bookRepository.findByTitle(title));
	}

	@Override
	public BookDto findById(long id) {
		return BookDtoMapper.toBookDto(bookRepository.getById(id));
	}

	@Override
	public void saveBook(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteById(long id) {
		bookRepository.delete(bookRepository.getById(id));
	}

	@Override
	public boolean existsByIsbn(String isbn) {
		return bookRepository.existsByIsbn(isbn);
	}

	@Override
	public List<Book> findBookByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn);
	}

	@Override
	public byte[] getImage(long id) {
		return bookRepository.getImageById(id);
	}

}
