package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.BorrowedBook;

@Repository
public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long>{

}
