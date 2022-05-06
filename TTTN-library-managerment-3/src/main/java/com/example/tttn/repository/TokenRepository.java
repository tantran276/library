package com.example.tttn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tttn.entity.Token;
import com.example.tttn.entity.User;

public interface TokenRepository extends JpaRepository<Token, Long>{
	boolean existsByUser(User user);
	Token findByValue(String value);
	Token findByUser(User user);
}
