package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Token;

public interface TokenRepository extends JpaRepository<Token, Long>{
	boolean existsByValue(String value);
}
