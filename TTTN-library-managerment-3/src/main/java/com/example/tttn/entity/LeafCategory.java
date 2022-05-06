package com.example.tttn.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "leaf_category")
public class LeafCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "leaf_category_name")
	private String leafCategoryName;
	
	@Column(name = "quantity")
	private long quantity;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private SubCategory subCategory;

	@JsonIgnore
	@OneToMany(mappedBy = "leafCategory", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Book> books;
}