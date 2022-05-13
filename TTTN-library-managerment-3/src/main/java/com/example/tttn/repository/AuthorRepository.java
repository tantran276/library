package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
