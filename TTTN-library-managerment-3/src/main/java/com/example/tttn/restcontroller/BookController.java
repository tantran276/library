package com.example.tttn.restcontroller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tttn.entity.Author;
import com.example.tttn.entity.Book;
import com.example.tttn.entity.Publisher;
import com.example.tttn.entity.Tag;
import com.example.tttn.payload.BookDto;
import com.example.tttn.repository.AuthorRepository;
import com.example.tttn.repository.CategoryRepository;
import com.example.tttn.repository.PublisherRepository;
import com.example.tttn.repository.TagRepository;
import com.example.tttn.service.interfaces.BookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	TagRepository tagRepository;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bookService.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getBookById(@PathVariable long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}
	
	@PutMapping
	public ResponseEntity<?> updateBook(@RequestBody BookDto bookDto) {
		List<Book> books = bookService.findBookByIsbn(bookDto.getIsbn());
		books.forEach(book -> {
			System.out.println(bookDto.getAuthor() + " " + bookDto.getAuthor1());
			try {
				book = this.toBook(book, bookDto);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bookService.saveBook(book);
		});
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping("/image/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable long id) {
		byte[] image = null;
		image = bookService.getImage(id);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG)
				.body(new ByteArrayResource(image));	
	}
	@PostMapping
	public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) throws ParseException {
		Book book = new Book();
		book.setStatus(true);
		bookService.saveBook(this.toBook(book, bookDto));
		return ResponseEntity.ok("Success");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable long id) {
		bookService.deleteById(id);
		return ResponseEntity.ok("Success");
	}

	public Book toBook(Book book,BookDto bookDto) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Set<Author> authors = new HashSet<>();
		if(bookDto.getAuthor()!= null && !bookDto.getAuthor().equals("")) {
			if(authorRepository.existsByName(bookDto.getAuthor())) {
				authors.add(authorRepository.findByName(bookDto.getAuthor()));
			} else {
				authorRepository.save(new Author(bookDto.getAuthor(), new ArrayList<Book>(Arrays.asList(book))));
				authors.add(authorRepository.findByName(bookDto.getAuthor()));
			}
		}
		if(bookDto.getAuthor1()!= null && !bookDto.getAuthor1().equals("")) {
			if(authorRepository.existsByName(bookDto.getAuthor1())) {
				authors.add(authorRepository.findByName(bookDto.getAuthor1()));
			} else {
				authorRepository.save(new Author(bookDto.getAuthor1(), new ArrayList<Book>(Arrays.asList(book))));
				authors.add(authorRepository.findByName(bookDto.getAuthor1()));
			}
		}
		book.setAuthors(authors);
		book.setTitle(bookDto.getTitle());
		book.setCategory(categoryRepository.findByName(bookDto.getCategory()));
		book.setContent(bookDto.getContent());
		book.setCreateDate(formatter.parse(bookDto.getCreateDate()));
		book.setIsbn(bookDto.getIsbn());
		book.setPrice(bookDto.getPrice());
		if (publisherRepository.existsByName(bookDto.getPublisher())) {
			book.setPublisher(publisherRepository.findByName(bookDto.getPublisher()));
		} else {
			publisherRepository.save(new Publisher(bookDto.getPublisher(), new ArrayList<Book>(Arrays.asList(book))));
			book.setPublisher(publisherRepository.findByName(bookDto.getPublisher()));
		}
		Set<Tag> tags = new HashSet<>();
		if(bookDto.getTag()!= null && !bookDto.getTag().equals("")) {
			if(tagRepository.existsByName(bookDto.getTag())) {
				tags.add(tagRepository.findByName(bookDto.getTag()));
			} else {
				tagRepository.save(new Tag(bookDto.getTag(), new ArrayList<Book>(Arrays.asList(book))));
				tags.add(tagRepository.findByName(bookDto.getTag()));
			}
		}
		if(bookDto.getTag1()!= null && !bookDto.getTag1().equals("")) {
			if(tagRepository.existsByName(bookDto.getTag1())) {
				tags.add(tagRepository.findByName(bookDto.getTag1()));
			} else {
				tagRepository.save(new Tag(bookDto.getTag1(), new ArrayList<Book>(Arrays.asList(book))));
				tags.add(tagRepository.findByName(bookDto.getTag1()));
			}
		}
		if(bookDto.getTag2()!= null && !bookDto.getTag2().equals("")) {
			if(tagRepository.existsByName(bookDto.getTag2())) {
				tags.add(tagRepository.findByName(bookDto.getTag2()));
			} else {
				tagRepository.save(new Tag(bookDto.getTag2(), new ArrayList<Book>(Arrays.asList(book))));
				tags.add(tagRepository.findByName(bookDto.getTag2()));
			}
		}
		book.setTags(tags);
		book.setTitle(bookDto.getTitle());
		return book;
	}
}
