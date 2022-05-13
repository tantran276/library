package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tttn.entity.SignUpBorrow;

@Repository
public interface SignUpBorrowRepository extends JpaRepository<SignUpBorrow, Long>{

}
