package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
