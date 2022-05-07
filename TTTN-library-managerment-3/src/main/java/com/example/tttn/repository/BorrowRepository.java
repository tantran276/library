package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long>{

}