package com.example.tttn.entity;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "isbn", length = 13, nullable = false)
	private String isbn;

	@Column(name = "title", length = 60, nullable = false)
	private String title;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_tag", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Tag> tags;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_liked", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	@JsonIgnore
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SignUpBorrow> signUpBorrows;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
	private List<Author> authors;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Publisher publisher;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private LeafCategory leafCategory;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private DocumentFormat documentFormat;
	
	@Column(name = "image")
	private Blob image;
	
	@Column(name = "price")
	private long price;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "create_date")
	private Date createDate;
}