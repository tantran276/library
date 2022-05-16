package com.example.tttn.mapper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.tttn.entity.Author;
import com.example.tttn.entity.Book;
import com.example.tttn.entity.Tag;
import com.example.tttn.payload.BookDto;

public class BookDtoMapper {
	public static BookDto toBookDto(Book book) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		BookDto bookDto = new BookDto();
		List<Author> authors = new ArrayList<>(book.getAuthors());
		if(authors.get(0) != null) {
			bookDto.setAuthor(authors.get(0).getName());
		}
		if(authors.size()>=2) {
			if(authors.get(1) != null) {
				bookDto.setAuthor1(authors.get(1).getName());
			}
		}
		bookDto.setCategory(book.getCategory().getCategoryName());
		bookDto.setContent(book.getContent());
		bookDto.setCreateDate(formatter.format(book.getCreateDate()));
		bookDto.setId(book.getId());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setPrice(book.getPrice());
		bookDto.setPublisher(book.getPublisher().getName());
		List<Tag> tags = new ArrayList<>(book.getTags());
		if(tags.get(0)!=null) {
			bookDto.setTag(tags.get(0).getName());
		}
		if (tags.size()>= 2) {
			if(tags.get(1)!=null) {
				bookDto.setTag1(tags.get(1).getName());
			}
		}
		if(tags.size() >= 3) {
			if(tags.get(2)!=null) {
				bookDto.setTag2(tags.get(2).getName());
			}
		}
		
		bookDto.setTitle(book.getTitle());
		return bookDto;
	}
}
