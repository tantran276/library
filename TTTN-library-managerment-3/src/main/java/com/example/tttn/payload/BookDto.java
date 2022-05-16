package com.example.tttn.payload;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private Long id;
	private String isbn;
	private String title;
	private String tag;
	private String tag1;
	private String tag2;
	private String author;
	private String author1;
	private String publisher;
	private String category;
	private String content;
	private long price;
	private String createDate;
	private File image;
}
