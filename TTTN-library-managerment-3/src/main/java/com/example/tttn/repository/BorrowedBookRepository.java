package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.BorrowedBook;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long>{

}
