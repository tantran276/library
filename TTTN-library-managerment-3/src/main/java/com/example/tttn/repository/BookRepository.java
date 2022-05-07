package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
